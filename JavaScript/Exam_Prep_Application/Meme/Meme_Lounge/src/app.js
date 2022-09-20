
import { logout } from "./api/data.js";
import { page, render } from "./lib.js";
import { getUserData } from "./util.js";

import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { homePage } from "./views/home.js";
import { loginPage } from "./views/login.js";
import { memePage } from "./views/meme.js";
import { profilePage } from "./views/profile.js";
import { registerPage } from "./views/register.js";


const main = document.querySelector('main');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(middleWare);
page('/', homePage);
page('/create', createPage)
page('/memes', memePage);
page('/login', loginPage);
page('/details/:id', detailsPage);
page('/edit/:id',editPage);
page('/register', registerPage);
page('/profile',profilePage);

updateNav();
page.start();


function onLogout(){
   
    logout();
    updateNav();
    page.redirect('/');
}

function middleWare(ctx, next) {
   
    ctx.render = (view) => render(view, main);
    ctx.updateNav = updateNav;
   
    next();
}

 function updateNav() {
     
    const userData = getUserData();

    if (userData) {
        document.querySelector('.user').style.dispay = 'block';
        document.querySelector('.guest').style.display = 'none';
        document.querySelector('.user span').textContent = `Welcome, ${userData.email}`;
    } else {
        document.querySelector('.user').style.display = 'none';
        document.querySelector('.guest').style.display = 'block';
    }
}