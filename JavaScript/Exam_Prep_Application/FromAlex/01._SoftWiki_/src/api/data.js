import * as api from './api.js';
export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function getAllArticles(){
    return api.get('/data/wiki?sortBy=_createdOn%20desc');
}

export async function getRecentArticles(){
    return api.get('/data/wiki?sortBy=_createdOn%20desc&distinct=category');
}

export async function createArticle(body){
    return api.post('/data/wiki',body);
}

export async function getDetails(id){
    return api.get('/data/wiki/'+id);
}

export async function editArticle(id,body){
    return api.put('/data/wiki/'+id,body)
}

export async function deleteArticle(id){
    return api.del('/data/wiki/'+id);
}