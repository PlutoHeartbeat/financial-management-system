<template>
  <div class="notifications">
    <div class="notification" v-for="(item, index) in notifications" :key="index">
      <h2>{{ item.title }}</h2>
      <div class="content">{{ item.content }}</div>
      <p class="date">{{ convertDate(item.publishDate) }}</p>
      <el-button @click="handleClick(index)" type="primary" class="button">点击查看详情</el-button>
    </div>
    <el-dialog :visible.sync="dialogVisible" width="50%">
      <h2>{{ currentNotification.title }}</h2>
      <p class="dialogContent">{{ currentNotification.content }}</p>
      <p class="date">{{ convertDate(currentNotification.publishDate) }}</p>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" style="margin-left: 670px;" type="primary" class="close-button">关闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {getNotice} from '@/api/notice';
export default {
  data() {
    return {
      notifications: [],
      dialogVisible: false,
      currentNotification: {}
    };
  },
  created(){
    getNotice().then(res => {
      this.notifications = res.data.reverse();
    })
  },
  methods: {
    handleClick(index) {
      this.currentNotification = this.notifications[index];
      this.dialogVisible = true;
    },
    convertDate(isoDateString) {
      const date = new Date(isoDateString);
      return date.toLocaleString();
    }
  }
};
</script>

<style scoped>
.notifications {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.notification {
  margin-top: 20px;
  width: 80%;
  padding: 20px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  background-color: #f8f9fa;
  margin-bottom: 10px;
  transition: transform 0.3s ease;
}

.content {
  margin: 0;
  font-size: 18px; /* 修改字体大小 */
  color: #666;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  line-height: 1.5; /* 增加行高以显示省略号 */
  max-width: 100%; /* 或者你可以设置一个特定的宽度或最大宽度 */
}

.date {
  display: block;
  float: right;
  font-size: 18px; /* 修改字体大小 */
  color: #666;
  margin: 10px 0; /* 在时间和内容之间添加距离 */
}

.notification:hover {
  transform: scale(1.02);
}
.dialogContent{
  font-size: 18px;
}
.notification h2 {
  margin: 0;
  margin-bottom: 10px;
  font-size: 24px; /* 修改字体大小 */
  font-weight: bold;
  color: #333;
}

.notification p {
  margin: 0;
  font-size: 18px;
  color: #666;
}

.notification .button {
  margin-top: 35px;
  padding: 10px 10px; /* 修改按钮高度 */
  border: none;
  border-radius: 3px;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.notification .button:hover {
  background-color: #0056b3;
}
.close-button {
  margin-left: auto;
}
</style>
