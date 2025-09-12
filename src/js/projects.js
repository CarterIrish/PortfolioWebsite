const dataPath = './src/data/projects.json';

window.addEventListener('DOMContentLoaded', () => {

  // Fetch and display projects from the JSON file
  populateProjectsContainer();

  // Query the cloudflare worker
  document.querySelector('#test-widget-btn').addEventListener('click', async () => {
    await fetchFromWorker();
  });
});

function populateProjectsContainer() {
  fetch(dataPath)
    .then(response => response.json())
    .then(data => {
      // Get projects container
      const projectsContainer = document.getElementById('projects-container');
      // Create HTML for each project
      const projectsHtml = data.map(project => `
      <div class="project-card">
        <img src="${project.image}" alt="${project.Title}" class="project-image"/>
        <div class="project-info">
          <h2 class="project-title">${project.Title}</h2>
          <p class="project-description">${project.description}</p>
          <a href="${project.link}" class="project-link" target="_blank" rel="noopener noreferrer">View Project</a>
        </div>
      </div>
    `).join('');

      // Insert projects HTML into the container
      projectsContainer.innerHTML = projectsHtml;

    });
}

async function fetchFromWorker() {
  const response = await fetch('https://spotify-widget.2023c-irish.workers.dev');
  const data = await response.json();
  console.log(data);
};
