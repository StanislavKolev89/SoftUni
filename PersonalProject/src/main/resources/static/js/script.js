
const toggleButton = document.getElementsByClassName('toggle-button')[0]
const navbarLinks = document.getElementsByClassName('navbar-links')[0]
toggleButton.addEventListener('click', () => {
  navbarLinks.classList.toggle('active')
})

//ToDO Make it work for all tables

// const allUsersBtn= document.getElementById('AllUsers');
// allUsersBtn.addEventListener('click', showAllUsersTable)
//
//
// function showAllUsersTable(){
//   for (const nodeListOfElement of document.querySelectorAll('table')) {
//       nodeListOfElement.style.display='none';
//   };
//
//   for (const nodeListOfElement of document.querySelectorAll('table')) {
//       if(nodeListOfElement.id.slice(5)==allUsersBtn.id){
//         nodeListOfElement.style.display='block';
//       }else{
//         nodeListOfElement.style.display='none';
//       }
//   };
//
// }