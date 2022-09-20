
import { deleteSingleBook, getSingleBook } from "../api/data.js";
import { html } from "../lib.js";
import { getUserData } from "../util.js";


const detailsTemplate = (book,isOwner,onDelete) => html`
<section id="details-page" class="details">
<div class="book-information">
    <h3>${book.title}</h3>
    <p class="type">Type: ${book.type}</p>
    <p class="img"><img src=${book.imageUrl}></p>
    <div class="actions">
    ${isOwner
    ? html`<a class="button" href="/edit/${book._id}">Edit</a>
        <a class="button" href="" @click =${onDelete}>Delete</a>`
        :html`<a class="button" href="#">Like</a>`
    } 
        <!-- ( for Guests and Users )  -->
        <div class="likes">
            <img class="hearts" src=${book.imageUrl}>
            <span id="total-likes">Likes: 0</span>
        </div>
        <!-- Bonus -->
    </div>
</div>
<div class="book-description">
    <h3>Description:</h3>
    <p>${book.description}</p>
</div>
</section>`


export async function detailsPage(ctx){
    const book = await getSingleBook(ctx.params.id);
    const user = await getUserData();
    const isOwner = (user && user.id == book._ownerId);
    console.log(isOwner);
    ctx.render(detailsTemplate(book,isOwner,onDelete));


    async function onDelete(){
        const result = confirm('Are you sure you want to delete the current book?');
        if(result){
             deleteSingleBook(ctx.params.id);
           ctx.page.redirect('/');
        }
    }

}