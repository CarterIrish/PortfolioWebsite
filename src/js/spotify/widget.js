// ===============================================================================
// Spotify Widget Frontend Logic
// TODO(human): Implement the widget display and refresh functionality
// ===============================================================================

class SpotifyWidget {
    constructor() {
        this.widget = document.getElementById('spotify-widget');
        this.albumArt = document.getElementById('album-art');
        this.trackName = document.getElementById('track-name');
        this.artistName = document.getElementById('artist-name');
        this.authButton = document.getElementById('spotify-authentication-btn');

        this.refreshInterval = null;
        this.isAuthenticated = false;

        this.init();
    }

    init() {
        // Check if user is already authenticated
        const accessToken = sessionStorage.getItem('spotify_access_token');
        const userId = localStorage.getItem('spotify_user_id');

        if (accessToken && userId) {
            this.isAuthenticated = true;
            this.hideAuthButton();
            this.startRefreshing();
        }
    }

    hideAuthButton() {
        if (this.authButton) {
            this.authButton.style.display = 'none';
        }
    }

    showAuthButton() {
        if (this.authButton) {
            this.authButton.style.display = 'block';
        }
    }

    async fetchCurrentlyPlaying() {
        console.log("Fetching currently playing track...");
        const accessToken = sessionStorage.getItem('spotify_access_token');
        const userId = localStorage.getItem('spotify_user_id');

        try {
            const response = await fetch('https://spotify-widget.2023c-irish.workers.dev/currently-playing',
                {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ access_token: accessToken, user_id: userId })
                }
            );

            const data = await response.json();

            if (data.success) {
                if (data.new_access_token) {
                    sessionStorage.setItem('spotify_access_token', data.new_access_token);
                }
                this.updateWidget(data);
            } else {
                // API returned an error response
                this.handleError(data);
            }
        } catch (error) {
            // Network error or JSON parsing failed
            console.error('Network error fetching currently playing:', error);
            this.handleError({ code: 'NETWORK_ERROR', message: error.message });
        }
    }

    // TODO(human): Implement updateWidget
    updateWidget(trackData) {
        // TODO(human): Check if trackData.isPlaying and trackData.track exist
        if (!trackData.isPlaying || !trackData.track) {
            this.widget.style.display = 'none';
            return;
        }
        console.log('Updating widget with track data:', trackData);
        this.albumArt.src = trackData.track.image;
        this.trackName.textContent = trackData.track.name;
        this.artistName.textContent = trackData.track.artist;
        this.widget.style.display = 'block';
    }

    startRefreshing() {
        // Fetch immediately
        this.fetchCurrentlyPlaying();
I
        // TODO(human): Set up interval to refresh every 10 seconds
        // Store in this.refreshInterval so it can be cleared later
        this.refreshInterval = setInterval(() => this.fetchCurrentlyPlaying(), 10000);
    }

    stopRefreshing() {
        if (this.refreshInterval) {
            clearInterval(this.refreshInterval);
            this.refreshInterval = null;
        }
    }

    handleError(error) {
        console.error('Spotify widget error:', error);

        const authErrorCodes = ['TOKEN_NOT_FOUND', 'INVALID_ACCESS_TOKEN', 'INVALID_USER_ID'];
        if(error.code && authErrorCodes.includes(error.code))
        {
            // Auth error so clear tokens and restart flow
            sessionStorage.removeItem('spotify_access_token');
            sessionStorage.removeItem('spotify_access_token_expires_at');
            localStorage.removeItem('spotify_user_id');
            this.isAuthenticated = false;
            this.showAuthButton();
            this.stopRefreshing();
        }
        else
        {
            console.warn('Non-auth error, will retry on next refresh:', error);
        }
        
    }
}

// Initialize widget when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    // Add class to indicate JavaScript is enabled
    document.body.classList.add('js-enabled');
    new SpotifyWidget();
});