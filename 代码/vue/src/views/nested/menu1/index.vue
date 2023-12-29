<template>
  <div>
    <div class="header" style="margin-top: 50px;width: 90%;margin-left: 10px;margin: 0 auto;">
      <!-- 数据统计-->
      <el-row :gutter="10">
          <el-col :span="6">
              <div class="statistics" style="background:#409eff" >
                  <div class="title">
                      <p>班费余额</p>
                      <el-tag size="mini" type="success">实时</el-tag>
                  </div>
                  <div class="num">4221</div>
                  <div style="margin-top: 10px;" class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#E6A23C" >
                  <div class="title">
                      <p>今日收缴</p>
                      <el-tag size="mini" type="info">实时</el-tag>
                  </div>
                  <div class="num">0</div>
                  <div class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#67C23A" >
                  <div class="title">
                      <p>本月收缴</p>
                      <el-tag size="mini" type="warning">实时</el-tag>
                  </div>
                  <div class="num">600</div>
                  <div class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#909399" >
                  <div class="title">
                      <p>班费缴纳次数</p>
                      <el-tag size="mini" type="primary">实时</el-tag>
                  </div>
                  <div class="num">7</div>
                  <div class="tip">次</div>
              </div>
          </el-col>
      </el-row>
    </div>
    <div class="footer" style="display: flex;">
      <div class="left">
        <div id="bar" style="margin-left: 100px;">
          <div id="myChart" style="width: 600px;height:400px;"></div>
        </div>
      </div>
      <div class="right" style="border: 1px solid rgb(130, 132, 134);box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.4);
      border-radius: 10px;margin-top: 80px;margin-left: 80px;">
        <el-form ref="form" :model="sizeForm" label-width="80px" size="big" style="padding: 30px;">
          <el-form-item label="缴费金额">
            <el-input v-model="sizeForm.name"></el-input>
          </el-form-item>
          <el-form-item label="缴费用途">
            <el-select v-model="sizeForm.region" placeholder="请选择缴费用途">
              <el-option label="团建活动" value="shanghai"></el-option>
              <el-option label="日常缴费" value="beijing"></el-option>
              <el-option label="其他非常规缴费" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="缴纳时间">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="sizeForm.date1" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
              <el-time-picker placeholder="选择时间" v-model="sizeForm.date2" style="width: 100%;"></el-time-picker>
            </el-col>
          </el-form-item>
          <!-- <el-form-item label="活动性质">
            <el-checkbox-group v-model="sizeForm.type">
              <el-checkbox-button label="美食/餐厅线上活动" name="type"></el-checkbox-button>
              <el-checkbox-button label="地推活动" name="type"></el-checkbox-button>
              <el-checkbox-button label="线下主题活动" name="type"></el-checkbox-button>
            </el-checkbox-group>
          </el-form-item> -->
          <!-- <el-form-item label="是否为非常规缴费">
            <el-radio-group v-model="sizeForm.resource" size="medium">
              <el-radio border label="是"></el-radio>
              <el-radio border label="否"></el-radio>
            </el-radio-group>
          </el-form-item> -->
          <el-form-item size="large">
            <el-button type="primary">提交</el-button>
            <el-button>重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
  data() {
      return {
        sizeForm: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      };
    },
  mounted() {
    this.createChart();
  },
  methods: {
    createChart() {
      let chart = echarts.init(document.getElementById('myChart'));
      let option = {
        title: {
          text: '1-6月收入统计图'  // 设置图表名称
        },
        xAxis: {
          name:'月份',
          data: ['一月', '二月', '三月', '四月', '五月', '六月']
        },
        yAxis: {
          name:'金额',
          boundaryGap: false
        },
        series: [{
          type: 'bar',
          data: [130, 240, 180, 550, 270, 380]
        }]
      };
      chart.setOption(option);
    },
    editIncome(index) {
      this.editing = index;
      this.$nextTick(() => {
        this.$refs.edit.focus();
      });
    },
    saveIncome(index) {
      this.incomes[index].amount = Number(this.$refs.edit.value);
      this.editing = null;
    },
  },
}
</script>

<style scoped>
.el-row {
  padding: 0 9px;
}

.el-row .statistics {
  color: white;
  height: 130px;
  border-radius: 4px;
  padding: 0 8px;
}

.el-row .statistics .title {
  display: flex; /* 弹性布局 */
  justify-content: space-between; /* 两边对齐 */
  align-items: center; /* 垂直居中 */
}

.el-row .statistics p {
  font-size: 18px;
  font-weight: bold;
}

.el-row .statistics .num {
  font-size: 25px;
  font-weight: bold;
  text-align: center;
}

.el-row .statistics .tip {
  font-size: 18px;
  font-weight: bold;
}
#bar {
  display: flex;
  justify-content: space-between; /* 添加这一行来实现左右布局 */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  max-width: 700px;
}
#myChart{
  max-width: 700px; /* 调整这个值来改变图表的宽度 */
}
</style>
