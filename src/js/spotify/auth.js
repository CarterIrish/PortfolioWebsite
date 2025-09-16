window.addEventListener('DOMContentLoaded', () => {
    const authButton = document.querySelector('#spotify-authentication-btn');
    authButton.addEventListener('click', spotifyAuthenticate);
});

async function spotifyAuthenticate() {
    // Handle Spotify authentication here

    // Generate a code verifier
    const generateRandomString = (length) => {
        const possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        const values = crypto.getRandomValues(new Uint8Array(length));
        return values.reduce((acc, x) => acc + possible[x % possible.length], "");
    }
    // Get the verifier
    const codeVerifier = generateRandomString(128);

    // Hash and base64-urlencode the verifier to create the challenge
    const sha256 = async (plain) => {
        const encoder = new TextEncoder();
        const data = encoder.encode(plain);
        return window.crypto.subtle.digest('SHA-256', data);
    }

    const base64encode = (input) => {
        return btoa(String.fromCharCode(...new Uint8Array(input)))
            .replace(/=/g, '')
            .replace(/\+/g, '-')
            .replace(/\//g, '_');
    }

    // get the hashed and encoded challenge
    const hashed = await sha256(codeVerifier);
    const codeChallenge = base64encode(hashed);
    // Assign the code verifier to session storage
    sessionStorage.setItem('spotify_code_verifier', codeVerifier);

    // Construct the redirect URL Params
    const clientId = "419ae3c6913946ffa0940c1ae6c08847"; // Safe to expose
    const redirectUri = new URL("https://carterirish.net/callback"); // Safe to expose
    const scope = "user-read-currently-playing user-read-playback-state user-read-email user-read-private";
    const authUrl = new URL("https://accounts.spotify.com/authorize");
    // Build the full URL
    const params = {
        response_type: 'code',
        client_id: clientId,
        scope: scope,
        code_challenge_method: 'S256',
        code_challenge: codeChallenge,
        redirect_uri: redirectUri,
    }
    // redirect to Spotify authorization URL
    authUrl.search = new URLSearchParams(params).toString();
    window.location.href = authUrl.toString();
}

