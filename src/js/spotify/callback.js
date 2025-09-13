console.log("callback.js loaded");
console.log("window.location.search:", window.location.search);

const params = new URLSearchParams(window.location.search);
const code = params.get('code');
const codeVerifier = sessionStorage.getItem('spotify_code_verifier');
console.log("code:", code, "codeVerifier:", codeVerifier);

fetch('https://spotify-widget.2023c-irish.workers.dev/auth',
    {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ code, code_verifier: codeVerifier })
    })
    .then(res => res.json())
    .then(data => {
        console.log("Worker response:", data);
        sessionStorage.setItem('spotify_access_token', data.access_token);
    })
    .catch(err => console.error("Fetch error:", err));