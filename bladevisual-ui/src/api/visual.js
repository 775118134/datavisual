import { url } from '@/config';

var request = window.axios;

export const getList = (params) => request({
    url: url + 'bladeVisuals/category/' + params.category,
    method: 'get',
    params: (({
        pageNum,
        pageSize
    }) => ({
        pageNum,
        pageSize
    }))(params)
});

export const updateObj = (data) => request({
    url: url + 'bladeVisuals',
    method: 'put',
    data: {
        "id": data.id,
        "password": data.password,
        "category": data.category,
        "status": data.status,
        "title": data.title
    }
});

export const delObj = (id) => request({
    url: url + 'bladeVisuals/' + id,
    method: 'delete'
});

/**
 * ========================== visualsDetail ==========================
 */

export const getObj = (id) => request({
    url: url + 'visualsDetail/' + id,
    method: 'get'
});

export const uploadImg = (file) => {
    var formdata = new FormData();
    formdata.append('file', file)
    return request({
        url: url + 'visualsDetail/upload',
        method: 'post',
        data: formdata,
        headers: {
            "Content-Type": "multipart/form-data"
        }
    })
};

export const addObj = (data) => request({
    url: url + 'visualsDetail',
    method: 'post',
    data: {
        visual: {
            password: data.password,
            category: data.category,
            status: data.status,
            title: data.title,
        },
        config: {
            detail: JSON.stringify({
                name: data.title,
                width: data.width,
                height: data.height,
                scale: 1,
                backgroundImage: '/img/bg/bg1.png',
                url: '',
                mark: {},
                gradeShow: false,
                gradeLen: 30,
            }),
            component: '[]'
        },
    }
});

export const copyObj = (id) => request({
    url: url + 'visualsDetail/copy',
    method: 'post',
    params: {
        id: id
    }
});

export const updateComponent = (data) => request({
    url: url + 'visualsDetail',
    method: 'put',
    data: data
});