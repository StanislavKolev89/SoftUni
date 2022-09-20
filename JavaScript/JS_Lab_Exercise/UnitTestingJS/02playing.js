function cards(face, suit) {
    const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    const suits = {
        'S': '♠',
        'H': '♥',
        'D': '♦',
        'C': '♣'
    }
    if (!faces.includes(face)) {
        throw Error('Error');
    } else {
        let obj = {
            suit: suits[suit],
            face: face,
            toString() {
                return `${face}${this.suit}`;
            }
        };
        return obj.toString();
    }
}



console.log(cards('A', 'S'));
console.log(cards('10', 'H'));
console.log(cards('1', 'C'));