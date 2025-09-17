
// Upon redirect from Spotify auth, exchange code for tokens via Worker endpoint

// Build the request to the Worker endpoint
const params = new URLSearchParams(window.location.search); // get query params from URL
const code = params.get('code'); // extract the authorization code
const codeVerifier = sessionStorage.getItem('spotify_code_verifier'); // retrieve the code verifier from session storage
// Log for debugging
console.log("code:", code, "codeVerifier:", codeVerifier);

fetch('http://127.0.0.1:8787/auth',
    {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ code, code_verifier: codeVerifier })
    })
    .then(res => res.json())
    .then(data => {
        console.log("Worker response:", data);
        let expiresIn = data.expires_in; // seconds from Spotify
        let expiresAt = Date.now() + expiresIn * 1000;
        sessionStorage.setItem('spotify_access_token', data.access_token);
        sessionStorage.setItem('spotify_access_token_expires_at', expiresAt);
        localStorage.setItem('spotify_user_id', data.user_id);
        console.log(`${data.user_id} tokens stored.`);
        // Redirect to home or another page after successful authentication
        window.location.href = '/';
    })
    .catch(err => console.error("Fetch error:", err));