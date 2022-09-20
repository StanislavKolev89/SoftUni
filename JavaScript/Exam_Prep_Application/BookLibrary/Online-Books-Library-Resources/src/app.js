import { logout } from './api/data.js';
import {  page, render } from './lib.js';
import { getUserData } from './util.js';
import { addBook } from './views/create.js';
import { showDashboard } from './views/dashboard.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { loginPage } from './views/login.js';
import { myBooksPage } from './views/mybooks.js';
import { registerPage } from './views/register.js';

const mainSection = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click',userLogout);
updateUserNav()

page(middleware);
page('/',showDashboard);
page('/login',loginPage);
page('/register',registerPage);
page('/addBook',addBook);
page('/details/:id',detailsPage);
page('/edit/:id',editPage);
page('/myBooks',myBooksPage);

page.start();

function middleware(ctx,next){
    ctx.updateUserNav = updateUserNav;
    ctx.render = (view)=> render(view,mainSection);
    next();
}


function updateUserNav(){
    const userData = getUserData();
    if(userData){
        document.getElementById('user').style.display ='block';
        document.getElementById('guest').style.display ='none';
        document.querySelector('#user span').textContent =`Welcome, ${userData.email}`;
    }else{
        document.getElementById('user').style.display ='none';
        document.getElementById('guest').style.display ='block';
    }
}

async function userLogout(ev){
    ev.preventDefault();
    await logout();
    updateUserNav();
    page.redirect('/')
}