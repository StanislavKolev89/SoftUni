import * as api from './api.js';
export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function createBook(book) {
    await api.post('/data/books', book);
}

export async function getAllBooks() {
    return await api.get('/data/books?sortBy=_createdOn%20desc');
}

export async function getSingleBook(id) {
    return await api.get('/data/books/' + id);
}

export async function updateSingleBook(id, book) {
    return await api.put('/data/books/' + id, book);
}

export async function deleteSingleBook(id) {
    return await api.del('/data/books/' + id);
}

export async function getMyBooks(userId){
    return await api.get(`/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`)
}
