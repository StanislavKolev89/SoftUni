class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = []
        this._likes = [];


    }

    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`
        } else if (this._likes.length == 1) {
            return `${this._likes[0]} likes this story!`
        } else {
            return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`
        }
    }

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error(`You can't like the same story twice!`);
        }

        if (this.creator == username) {
            throw new Error(`You can\'t like your own story!`);
        }
        this._likes.push(username);

        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (!this._likes.includes(username)) {
            throw new Error(`You can't dislike this story!`);
        }

        this._likes = this._likes.filter(u => u !== username);
        return `${username} disliked ${this.title}`


    }

    comment(username, content, id) {

        if (id === undefined || !idExists(this._comments, id)) {
            id = this._comments.length + 1;
            this._comments.push({
                Id: id,
                Username: username,
                Content: content,
                Replies: []
            });
            return `${username} commented on ${this.title}`
        } else {
            let obj = findObj(this._comments, id);
            let numOfId = obj.Id;
            let numOfReplies = numOfId + '.' + (obj.Replies.length + 1);
            numOfReplies = Number(numOfReplies);
            obj.Replies.push({ Id: numOfReplies, Username: username, Content: content });
            return `You replied successfully`;
        }

        function findObj(comments, id) {
            for (const person of comments) {
                if (person.Id == id) {
                    return person;
                }
            }
        }

        function idExists(comments, id) {
            for (const comment of comments) {
                if (comment.Id === id) {
                    return true;
                }
            }
            return false;
        }
    }

    toString(command) {

        let result = [];
        result.push(`Title: ${this.title}`);
        result.push(`Creator: ${this.creator}`);
        result.push(`Likes: ${this._likes.length}`);
        result.push(`Comments:`);
        if (this._comments.length > 0) {
            let predicateForComments = {
                'asc': (a, b) => a.Id - b.Id,
                'desc': (a, b) => b.Id - a.Id,
                'username': (a, b) => a.Username.localeCompare(b.Username)
            }


            this._comments.sort(predicateForComments[command]).forEach(obj => {
                result.push(`-- ${obj.Id}. ${obj.Username}: ${obj.Content}`)
                if (obj.Replies.length > 0) {
                    obj.Replies.sort(predicateForComments[command]).forEach(e => result.push(`--- ${e.Id}. ${e.Username}: ${e.Content}`));
                
                }
            });
        }
        return result.join('\n');
    }
}


let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));
console.log();
console.log(art.toString('asc'));