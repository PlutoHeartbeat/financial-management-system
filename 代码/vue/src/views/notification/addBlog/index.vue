<template>
  <div style="height: 100%">
    <!-- 表单，绑定form -->
    <el-form :model="form" label-width="120px">
      <el-form-item label="标题" style="margin-top: 10px;">
        <el-input
          style="width: 80%;"
          v-model="form.title"
          placeholder="请输入标题"
        />
      </el-form-item>
      <el-form-item label="通知" style="margin-top: 10px;">
        <el-input
          style="width: 80%;height: 100px;display: block;height: 130px;"
          v-model="form.content"
          :rows="5"
          type="textarea"
          placeholder="请输入"
        />
      </el-form-item>
      <el-form-item label="提交时间" style="margin-top: 10px;">
        <el-date-picker
          v-model="form.date"
          type="datetime"
          placeholder="选择日期和时间"
          style="width: 80%;"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="postNotices">发布</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


   
<script>
import {postNotice} from '@/api/notice';
export default {
  data() {
    return {
      form: {
        title: "",
        content: "",
      },
    };
  },
  methods: {
    postNotices() {
      postNotice(this.form).then((res) => {
        if (res.code === "200") {
          this.$message({
            message: "提交成功",
            type: "success",
          });
        } else {
          this.$message({
            message: "出错了，请重新提交",
            type: "error",
          });
        }
      });
    },
  },
};
</script>
   
<style scoped>
</style>