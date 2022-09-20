// import { logout } from "./api/data.js";
// import { render } from "./lib.js";
// import { page } from "./lib.js";
// import { getUserData } from "./util.js";



// const mainSection = document.getElementById('main-content');
// document.getElementById('logoutBtn').addEventListener('click', userLogout);
// updateUserNav();

// page(middleware);

// page.start();

// function middleware(ctx, next) {
//     ctx.updateUserNav = updateUserNav;
//     ctx.render = (view) => render(view, mainSection);
//     next();
// }


// function updateUserNav() {
//     const userData = getUserData();
//     if (userData) {
//         document.getElementById('user').style.display = 'block';
//         document.getElementById('guest').style.display = 'none';
//     } else {
//         document.getElementById('user').style.display = 'none';
//         document.getElementById('guest').style.display = 'block';
//     }
// }

// async function userLogout(ev) {
//     ev.preventDefault();
//     await logout();
//     updateUserNav();
//     page.redirect('/')
// }
// export async function getlatestGames() {
//     return api.get('/data/games?sortBy=_createdOn%20desc&distinct=category');
// }

// console.log(getlatestGames());
// console.log('it Works');

console.log('it works');