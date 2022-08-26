import { url } from '@/config';

var request = window.axios;

export const getAllList = (params) => request({
    url: url + 'bladeVisualCategorys/list',
    method: 'get'
});

export const getList = (params) => request({
    url: url + 'bladeVisualCategorys',
    method: 'get',
    params: params
});

export const getObj = (id) => request({
    url: url + 'bladeVisualCategorys/' + id,
    method: 'get'
});

export const addObj = (data) => request({
    url: url + 'bladeVisualCategorys',
    method: 'post',
    data: data
});

export const updateObj = (data) => request({
    url: url + 'bladeVisualCategorys',
    method: 'put',
    data: data
});

export const delObj = (id) => request({
    url: url + 'bladeVisualCategorys/' + id,
    method: 'delete'
});