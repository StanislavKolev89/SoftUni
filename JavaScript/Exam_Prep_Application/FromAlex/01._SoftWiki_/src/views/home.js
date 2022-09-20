import { getRecentArticles } from "../api/data.js";
import { html } from "../lib.js";

const homeTemplate = (recent) => html`
<section id="home-page" class="content">
    <h1>Recent Articles</h1>
    ${recent.map(singleArticleTemplate)}

</section>`;

const singleArticleTemplate = (article) => html`
<section class="recent ${article.category}">
    <h2>${article.category}</h2>
    ${article.content !=undefined ? html`
    <article>
        <h3>${article.title}</h3>
        <p>${article.content}</p>
        <a href="/details/${article._id}" class="btn details-btn">Details</a>
    </article>`: html`
    <h3 class="no-articles">No articles yet</h3>`}
</section>`



export async function homePage(ctx) {
    const recent = await getRecentArticles();
    ctx.render(homeTemplate(recent,singleArticleTemplate));
    
}