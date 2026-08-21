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

// "In Development" -> "in-development", which is the modifier .status reads for
// its dot colour. An unrecognised status renders with no dot rather than a wrong one.
function statusModifier(status) {
  return status.toLowerCase().replace(/\s+/g, '-');
}

function buildProjectCard(project) {
  const status = project.status
    ? `<div class="status ${escapeHtml(statusModifier(project.status))}">${escapeHtml(project.status)}</div>`
    : '';

  const tech = Array.isArray(project.tech) && project.tech.length
    ? `<ul class="tech-row">${project.tech.map((item) => `<li class="tech-chip">${escapeHtml(item)}</li>`).join('')}</ul>`
    : '';

  const link = project.link && project.link !== 'none'
    ? `<a href="${escapeHtml(project.link)}" class="link-grow" target="_blank" rel="noopener noreferrer">View Project</a>`
    : '';

  return `
      <div class="pf-card">
        <img src="${escapeHtml(project.image)}" alt="${escapeHtml(project.Title)}" class="card-media" loading="lazy" decoding="async" />
        ${status}
        <h3 class="h3">${escapeHtml(project.Title)}</h3>
        <p class="card-text">${escapeHtml(project.description)}</p>
        ${tech}
        ${link}
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
        '<p class="projects-fallback">Projects could not be loaded right now. You can browse them all on <a class="link-grow" href="https://github.com/CarterIrish" target="_blank" rel="noopener noreferrer">GitHub</a>.</p>';
    });
}
