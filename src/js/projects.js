const dataPath = './src/data/projects.json';

window.addEventListener('DOMContentLoaded', () => {
  populateProjectsContainer();
});

// Escapes text before it goes into innerHTML. The data is authored by hand, but a
// stray < or & in a description would otherwise break the markup silently.
function escapeHtml(value) {
  return String(value).replace(/[&<>"']/g, (char) => ({
    '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;'
  })[char]);
}

function buildProjectCard(project) {
  const status = project.status
    ? `<span class="project-tag ${escapeHtml(project.status.toLowerCase().replace(/\s+/g, '-'))}">${escapeHtml(project.status)}</span>`
    : '';

  const tech = Array.isArray(project.tech) && project.tech.length
    ? `<ul class="project-tech">${project.tech.map((item) => `<li>${escapeHtml(item)}</li>`).join('')}</ul>`
    : '';

  const link = project.link && project.link !== 'none'
    ? `<a href="${escapeHtml(project.link)}" class="project-link" target="_blank" rel="noopener noreferrer">View Project</a>`
    : '';

  return `
      <div class="project-card">
        ${status}
        <img src="${escapeHtml(project.image)}" alt="${escapeHtml(project.Title)}" class="project-image" loading="lazy" decoding="async" />
        <div class="project-info">
          <h2 class="project-title">${escapeHtml(project.Title)}</h2>
          <p class="project-description">${escapeHtml(project.description)}</p>
          ${tech}
          ${link}
        </div>
      </div>
    `;
}

function populateProjectsContainer() {
  const projectsContainer = document.getElementById('projects-container');
  if (!projectsContainer) return;

  fetch(dataPath)
    .then((response) => {
      // fetch only rejects on network failure, so a 404 still resolves. Without this
      // check a missing file becomes a JSON parse error and the section silently empties.
      if (!response.ok) throw new Error(`Could not load projects (${response.status})`);
      return response.json();
    })
    .then((data) => {
      projectsContainer.innerHTML = data.map(buildProjectCard).join('');
    })
    .catch((error) => {
      console.error(error);
      // Never leave the section blank. A visitor who hits this still gets somewhere to go.
      projectsContainer.innerHTML =
        '<p class="projects-fallback">Projects could not be loaded right now. You can browse them all on <a class="project-link" href="https://github.com/CarterIrish" target="_blank" rel="noopener noreferrer">GitHub</a>.</p>';
    });
}
