function request(obj) {
    let method = obj.method;
    let uri = obj.uri;
    let version = obj.version;
    let message = obj.message;
    try{
     validateMethod(method);
  validateUri(uri);
        validateVersion(version);
        validateMessage(message);
        return obj;
    }catch(ex){
        return ex.message;
    } 

    function validateMethod(method) {
        let methods = ['GET', 'POST', 'DELETE', 'CONNECT'];
        if (!methods.includes(method) || method == undefined) {
            throw Error(`Invalid request header: Invalid Method`);
        }
    }

    function validateUri(uri) {
        let regExp = /^[\w.]+$/;
        if (!regExp.test(uri) || uri =='*' || uri == undefined) {
            throw Error(`Invalid request header: Invalid URI`);
        }
    }

    function validateVersion(version) {
        let versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

        if (!versions.includes(version) || version == undefined) {
            throw Error(`Invalid request header: Invalid Version`);
        }
    }

    function validateMessage(message) {
        let reg = /^[^<>\\&'"]*$/;
        if (!reg.test(message) || message == '' || message == undefined) {
            throw Error(`Invalid request header: Invalid Message`);
        }
    }

}

// console.log(request({
//     method: 'GET',
//     uri: 'svn.public.catalog',
//     version: 'HTTP/1.1',
//     message: ''
//   }));

//   console.log(request({
//     method: 'OPTIONS',
//     uri: 'git.master',
//     version: 'HTTP/1.1',
//     message: '-recursive'
//   })); 
  
  console.log(request({
    method: 'POST',
    uri: 'home.bash',
    message: 'rm -rf /*'
  }));