function encodeAndDecodeMessages() {
    let [encodeBtn, decodeBtn] = Array.from(document.getElementsByTagName('button'));
    let [inputMsg, outputMsg] = Array.from(document.getElementsByTagName('textarea'));
    let messageToSent = '';
    let final = ''
    encodeBtn.addEventListener('click', encodeMsg);
    decodeBtn.addEventListener('click', decodeMsg);


    function encodeMsg(e) {
        let messageToEncode = inputMsg.value.split('');
     
        for (let i = 0; i < messageToEncode.length; i++) {
            let a = messageToEncode[i];
            let b = Number(a.charCodeAt(0)) + 1;
            messageToSent += String.fromCharCode(b);

        }
        final = inputMsg.value;
        inputMsg.value = '';
        outputMsg.value = messageToSent;
        messageToSent='';
    }

    function decodeMsg(e) {
        outputMsg.value = final;
    }
}