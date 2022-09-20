import { registerPage } from "./views/register.js";
import { logout } from "./api/data.js";
import { render } from "./lib.js";
import { page } from "./lib.js";
import { getUserData } from "./util.js";
import { catalogPage } from "./views/catalog.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";



const mainSection = document.getElementById('main-content');
 document.getElementById('logoutBtn').addEventListener('click', userLogout);
updateUserNav();

page(middleware);
page('/',homePage);
page('/catalog',catalogPage);
page('/login',loginPage);
page('/register',registerPage);
page('/create',createPage);
page('/details/:id',detailsPage);
page('/edit/:id',editPage);


page.start();

function middleware(ctx, next) {
    ctx.updateUserNav = updateUserNav;
    ctx.render = (view) => render(view, mainSection);
    next();
}


function updateUserNav() {
    const userData = getUserData();
    if (userData) {
        document.getElementById('user').style.display = 'block';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'block';
    }
}

async function userLogout(ev) {
    ev.preventDefault();
    await logout();
    updateUserNav();
    page.redirect('/')
}

