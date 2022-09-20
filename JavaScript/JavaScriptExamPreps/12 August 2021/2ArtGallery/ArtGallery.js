class ArtGallery {
    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = { "picture": 200, "photo": 50, "item": 250 };
        this.listOfArticles = [];
        this.guests = [];

    }


    addArticle(articleModel, articleName, quantity) {
        if (!this.possibleArticles.hasOwnProperty(articleModel.toLowerCase())) {
            throw new Error('This article model is not included in this gallery!');
        }
        let filtered = this.listOfArticles.filter(e => e.articleName == articleName);

        if (filtered.length == 0) {
            this.listOfArticles.push({
                articleModel: articleModel.toLowerCase(),
                articleName,
                quantity: Number(quantity)
            });
        } else {

            let points = Object.values(filtered[0])[2];
            filtered[0].quantity = points+quantity;
        }

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`
    }

    inviteGuest(guestName, personality) {
        const personalityPoints = {
            "Vip": 500,
            "Middle": 250
        }
        let searched = this.guests.filter(e => e.guestName == guestName);
        if (searched.length>0) {
            throw new Error(`${guestName} has already been invited.`)
        }

        const pointsToAdd = personalityPoints.hasOwnProperty(personality) ? personalityPoints[personality] : 50;
        this.guests.push({
            guestName,
            points: pointsToAdd,
            purchaseArticle: 0
        })

        return `You have successfully invited ${guestName}!`
    }

    buyArticle(articleModel, articleName, guestName) {
        let filtered = this.listOfArticles.filter(s => s.articleName == articleName);
        if (filtered.length == 0 || filtered[0].articleModel != articleModel) {
            throw new Error ("This article is not found.");
        }

        if (filtered[0].quantity == 0) {
            return `The ${articleName} is not available.`
        }

        let guestFilter = this.guests.filter(s => s.guestName == guestName);

        if (guestFilter == undefined) {
            return `This guest is not invited.`
        }

        const necesseryPoints = this.possibleArticles[articleModel];
        const guestPoints = guestFilter[0].points;

        if (guestPoints < necesseryPoints) {
            return "You need to more points to purchase the article.";
        }

        guestFilter[0].points = guestPoints - necesseryPoints;
        guestFilter[0].purchaseArticle++;
        filtered[0].quantity = filtered[0].quantity-1;
        return `${guestName} successfully purchased the article worth ${necesseryPoints} points.`
       
    }


    showGalleryInfo(criteria) {
        let result = [];

        if (criteria == 'article') {
            result.push('Articles information:');
            this.listOfArticles.forEach(e => result.push(`${e.articleModel} - ${e.articleName} - ${e.quantity}`))
        } else if (criteria == 'guest') {
            result.push('Guests information:');
            this.guests.forEach(e => result.push(`${e.guestName} - ${e.purchaseArticle}`))
        }
        return result.join('\n');
    }


}

const artGallery = new ArtGallery('Curtis Mayfield');
console.log(artGallery.inviteGuest('John', 'Vip'));
console.log(artGallery.inviteGuest('Peter', 'Middle'));
console.log(artGallery.inviteGuest('John', 'Middle'));