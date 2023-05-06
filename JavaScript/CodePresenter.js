

function displayCode(proj)
{
            var elem = document.getElementById("project"+proj);
            if(elem.style.display==="none")
                {
                    elem.style.display = "block";
                }
            else
                {
                    elem.style.display = "none";
                }
}

function displayWebsites(site)
    {
        var elem = document.getElementById("website"+site);
        if(elem.style.display==="none")
            {
                elem.style.display = "block";
            }
        else
            {
                elem.style.display = "none";
            }
    }
function displayApps(app)
    {
        var elem = document.getElementById("app"+app);
        if(elem.style.display==="none")
            {
                elem.style.display = "block";
            }
        else
            {
                elem.style.display = "none";
            }
    }
