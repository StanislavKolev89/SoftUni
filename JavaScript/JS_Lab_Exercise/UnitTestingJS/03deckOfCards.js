function printDeckOfCards(cards) {

    let result = [];
    function createCard(cards) {
        let face = '';
        let suit = '';
        let invalidCardFound = false;
        let invalidCard = '';
        for (const el of cards) {
            face = el.slice(0, -1);
            suit = el.slice(-1);

            cards(face, suit);
            function cards(face, suit) {
                
                const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
                const suits = {
                    'S': '♠',
                    'H': '♥',
                    'D': '♦',
                    'C': '♣'
                }
                if (!faces.includes(face)) {
                     invalidCard = `Invalid card: ${face}${suit}`;
                    invalidCardFound = true;
                } else {
                    let obj = {
                        suit: suits[suit],
                        face: face,
                        toString() {
                            return `${face}${this.suit}`;
                        }
                    };
                    result.push(obj);
                }
            }
        }

        if (invalidCardFound) {
            console.log(invalidCard);
        } else {
            console.log(result.join(' ').toString());
        }
    }
    createCard(cards);


}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);