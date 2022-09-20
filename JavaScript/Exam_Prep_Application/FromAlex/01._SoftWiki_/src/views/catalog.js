import { getAllArticles } from "../api/data.js";
import { html } from "../lib.js";

const catalogTemplate = (articles, singleArticle) => html`
<section id="catalog-page" class="content catalogue">
    ${articles.length > 0
        ?
            html`
    <h1>All Articles</h1>
    ${articles.map(singleArticle)}` 
    : html`<h3 class="no-articles">No articles yet</h3>`};
`

const singleArticle = (article) => html`
<a class="article-preview" href="/details/${article._id}">
    <article>
        <h3>Topic: <span>${article.title}</span></h3>
        <p>Category: <span>${article.category}</span></p>
    </article>
</a>`




export async function catalogPage(ctx) {
    const getAll = await getAllArticles();
    ctx.render(catalogTemplate(getAll, singleArticle));
}