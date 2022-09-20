import { getMemeById, updateSingleMeme } from "../api/data.js";
import { html } from "../lib.js";
import { notify } from "../notify.js";


const editTemplate = (onSubmit, meme) => html`
<section id="edit-meme">
    <form @submit=${onSubmit} id="edit-form">
        <h1>Edit Meme</h1>
        <div class="container">
            <label for="title">Title</label>
            <input id="title" type="text" placeholder="Enter Title" .value="${meme.title}" name="title">
            <label for="description">Description</label>
            <textarea id="description" placeholder="Enter Description" .value="${meme.description}" name="description">

            </textarea>
            <label for="imageUrl">Image Url</label>
            <input id="imageUrl" type="text" placeholder="Enter Meme ImageUrl" .value="${meme.imageUrl}"
                name="imageUrl">
            <input type="submit" class="registerbtn button" value="Edit Meme">
        </div>
    </form>
</section>`;


export async function editPage(ctx) {
    const id = ctx.params.id;
    const meme = await getMemeById(id);

    ctx.render(editTemplate(onSubmit, meme));

    async function onSubmit(event) {
        event.preventDefault();
        const formData = new FormData(event.target);
        const title = formData.get('title').trim();
        const description = formData.get('description').trim();
        const imageUrl = formData.get('imageUrl').trim();


        if (title == '' || description == '' || imageUrl == '') {
            return notify('All field are required');
        }

        updateSingleMeme({ title, description, imageUrl }, id);

        ctx.page.redirect('/memes');
    }
}