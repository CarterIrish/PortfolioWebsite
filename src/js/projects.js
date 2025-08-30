const dataPath = './src/data/projects.json';

// Fetch and display projects from the JSON file
fetch(dataPath)
  .then(response => response.json())
  .then(data => {
    // Get projects container
    const projectsContainer = document.getElementById('projects-container');
    // Create HTML for each project
    const projectsHtml = data.map(project => `
      <div class="project-card">
        <img src="${project.image}" alt="${project.Title}" class="project-image"/>
        <h2 class="project-title">${project.Title}</h2>
        <p class="project-description">${project.description}</p>
        <a href="${project.link}" class="project-link" target="_blank" rel="noopener noreferrer">View Project</a>
      </div>
    `).join('');

    // Insert projects HTML into the container
    projectsContainer.innerHTML = projectsHtml;
    
  })