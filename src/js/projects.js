const dataPath = './src/data/projects.json';

window.addEventListener('DOMContentLoaded', () => {

  // Fetch and display projects from the JSON file
  populateProjectsContainer();
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
        ${project.status ? `<span class="project-tag ${project.status.toLowerCase().replace(/\s+/g, '-')}">${project.status}</span>` : ''}
        <img src="${project.image}" alt="${project.Title}" class="project-image"/>
        <div class="project-info">
          <h2 class="project-title">${project.Title}</h2>
          <p class="project-description">${project.description}</p>
          ${project.link !== "none" ? `<a href="${project.link}" class="project-link" target="_blank" rel="noopener noreferrer">View Project</a>` : ''}
        </div>
      </div>
    `).join('');

      // Insert projects HTML into the container
      projectsContainer.innerHTML = projectsHtml;

    });
}
