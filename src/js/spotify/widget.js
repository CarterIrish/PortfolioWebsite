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

    // TODO(human): Implement fetchCurrentlyPlaying
    async fetchCurrentlyPlaying() {
        console.log("Fetching currently playing track...");
        // TODO(human): Get access_token from sessionStorage
        const accessToken = sessionStorage.getItem('spotify_access_token');
        // TODO(human): Get user_id from localStorage
        const userId = localStorage.getItem('spotify_user_id');
        console.log('Tokens:', { accessToken, userId }); // Add this too
        // TODO(human): Make POST request to worker endpoint '/currently-playing'
        fetch('https://spotify-widget.2023c-irish.workers.dev/currently-playing',
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ access_token: accessToken, user_id: userId })
            }
        )
            .then(res => res.json())
            .then(data => {
                if (data.success) {
                    if (data.new_access_token) {
                        sessionStorage.setItem('spotify_access_token', data.new_access_token);
                    }
                    this.updateWidget(data);
                }
                else {
                    this.handleError(data)
                }
            }).catch
            (error => {
                this.handleError(error);
            });
    }

    // TODO(human): Implement updateWidget
    updateWidget(trackData) {
        // TODO(human): Check if trackData.isPlaying and trackData.track exist
        if (!trackData.isPlaying || !trackData.track) {
            this.widget.style.display = 'none';
            return;
        }
        this.albumArt.src = trackData.track.image;
        this.trackName.textContent = trackData.track.name;
        this.artistName.textContent = trackData.track.artist;
        this.widget.style.display = 'block';
    }

    startRefreshing() {
        // Fetch immediately
        this.fetchCurrentlyPlaying();

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