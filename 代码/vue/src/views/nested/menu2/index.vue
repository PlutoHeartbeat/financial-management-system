<template>
  <div>
    <div class="header" style="margin-top: 50px;width: 90%;margin-left: 10px;margin: 0 auto;">
      <!-- 数据统计-->
      <el-row :gutter="10">
          <el-col :span="6">
              <div class="statistics" style="background:#409eff" >
                  <div class="title">
                      <p>总报销</p>
                      <el-tag size="mini" type="success">实时</el-tag>
                  </div>
                  <div class="num">4221</div>
                  <div style="margin-top: 10px;" class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#E6A23C" >
                  <div class="title">
                      <p>本月总报销</p>
                      <el-tag size="mini" type="info">实时</el-tag>
                  </div>
                  <div class="num">0</div>
                  <div class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#67C23A" >
                  <div class="title">
                      <p>今日报销</p>
                      <el-tag size="mini" type="warning">实时</el-tag>
                  </div>
                  <div class="num">600</div>
                  <div class="tip">元</div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="statistics" style="background:#909399" >
                  <div class="title">
                      <p>班费报销总次数</p>
                      <el-tag size="mini" type="primary">实时</el-tag>
                  </div>
                  <div class="num">7</div>
                  <div class="tip">当前总销售(元)</div>
              </div>
          </el-col>
      </el-row>
    </div>
    <div class="footer" style="display: flex;">
      <div class="left">
        <div id="pie" style="margin-left: 100px;">
          <div id="myChart" style="width: 600px;height:500px;"></div>
        </div>  
      </div>
      <div class="right"  style="border: 1px solid rgb(130, 132, 134);box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.4);
      border-radius: 10px;margin-top: 80px;margin-left: 80px;">
        <el-form ref="form" :model="sizeForm" label-width="80px" size="big" style="padding: 30px;">
          <el-form-item label="报销金额">
            <el-input v-model="sizeForm.name"></el-input>
          </el-form-item>
          <el-form-item label="报销类别">
            <el-select v-model="sizeForm.region" placeholder="请选择报销类别">
              <el-option label="团建活动" value="shanghai"></el-option>
              <el-option label="日常报销" value="beijing"></el-option>
              <el-option label="其他" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="报销时间">
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
          </el-form-item>
          <el-form-item label="特殊资源">
            <el-radio-group v-model="sizeForm.resource" size="medium">
              <el-radio border label="线上品牌商赞助"></el-radio>
              <el-radio border label="线下场地免费"></el-radio>
            </el-radio-group> -->
          <!-- </el-form-item> -->
          <el-form-item size="large">
            <el-button type="primary">提交</el-button>
            <el-button>取消</el-button>
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
          text: '月度支出占比',
          subtext: '数据仅供参考',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left',
        },
        series: [
          {
            name: '支出',
            type: 'pie',
            radius: '50%',
            data: [
              {value: 1048, name: '办公用品'},
              {value: 735, name: '员工薪酬'},
              {value: 580, name: '市场营销'},
              {value: 484, name: '研发投入'},
              {value: 300, name: '租金'},
              {value: 250, name: '差旅费'},
              {value: 200, name: '培训费用'},
              {value: 150, name: '设备购置'}
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
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

#myChart{
  max-width: 700px; /* 调整这个值来改变图表的宽度 */
}
#pie {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
