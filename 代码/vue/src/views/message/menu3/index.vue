<template>
  <div style="margin-top: 50px;">
   <el-row class="elrow">
       <el-col :span="8" v-for="(image, index) in images" :key="index">
         <el-card :body-style="{ padding: '0px' }" class="card">
             <img :src="image[0]" :alt="image[1]" class="image" @click="showImage(index)" ref="image"/>
             <div style="padding: 14px;">
             <span>{{createTime(image[1])}}</span>
             <div class="bottom clearfix">
                 <el-button type="text" class="button" @click="showImage(index)">查看详情</el-button>
             </div>
             </div>
         </el-card>
       </el-col>
   </el-row>
 </div> 
</template>

<script>
import { getImage } from '@/api/account';
import {BASEURL} from '@/utils/request2';
import Viewer from 'viewerjs';
import 'viewerjs/dist/viewer.css';

export default {
 data() {
   return {
     images: [],
     viewer: [],
   };
 },

 async created() {
   const res = await getImage();
   for (const key in res) {
      res[key][0] = BASEURL + res[key][0];
   }
   this.images = res.reverse();
   console.log(this.image)
   console.log9
   this.$nextTick(() => {
      this.$refs.image.forEach((image, index) => {
        this.viewer[index] = new Viewer(image, {
          // 配置项
        });
      });
    });
 },

 methods:{
   createTime(filename){
     let timestamp = filename.split('_')[0];
     let year = timestamp.substring(0, 4);
     let month = timestamp.substring(4, 6);
     let day = timestamp.substring(6, 8);
     let hour = timestamp.substring(8, 10);
     let minute = timestamp.substring(10, 12);
     let second = timestamp.substring(12, 14);
     return year + "年" + month + "月" + day + "日" +"\t"+ hour + "：" + minute + "：" + second;
   },
   showImage(index) {
    if (this.viewer[index]) {
      this.viewer[index].view().show();
    }
  }
 }
}
</script>

<style scoped>
.elrow {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}

.elrow > div {
  flex: 0 0 30%;
  max-width: 30%;
  margin: 10px 1%; /* 添加上下间距和左右间距 */
}

.card {
 width: 100%;
 height: 400px;
}

.image{
 height: 300px;
 width: 100%;
 cursor: pointer; /* 添加鼠标手型 */
}
</style>
