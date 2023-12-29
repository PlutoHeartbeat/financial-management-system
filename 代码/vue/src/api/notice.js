import request from '@/utils/request2'

// 获取通知
export function getNotice() {
    return request({
        url: '/notice/get',
        method: 'get',
    })
}

// 发布通知
export function postNotice(data) {
    return request({
        url: '/notice/create',
        method: 'post',
        data
    })
}
