import request from '@/utils/request2'

// 上传文件
export function postImage(file) {
    const formData = new FormData();
    formData.append('file', file);
    return request({
        url: '/voucher/upload',
        method: 'post',
        data: formData
    })
}

//下载文件
export function getImage() {
    // 发送GET请求
    return request({
        url: '/voucher/list', 
        method: 'get',
    })
}