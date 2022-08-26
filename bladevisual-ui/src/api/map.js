import { url } from '@/config';

var request = window.axios;

export const getList = (params) => request({
    url: url + 'bladeVisualMaps',
    method: 'get',
    params: params
});

export const getObj = (id) => request({
    url: url + 'bladeVisualMaps/' + id,
    method: 'get'
});

export const addObj = (data) => request({
    url: url + 'bladeVisualMaps',
    method: 'post',
    data: data
});

export const updateObj = (data) => request({
    url: url + 'bladeVisualMaps',
    method: 'put',
    data: data
});

export const delObj = (id) => request({
    url: url + 'bladeVisualMaps/' + id,
    method: 'delete'
});