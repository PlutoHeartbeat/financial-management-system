<template>
  <div class="charge-container" id="chargeContainer">
    <div class="charge" ref="chargeContainer">
      <div class="charge-header">
        <span :span="6" class="sortRow" style="justify-content: flex-start">
          <span :span="10" class="sortCol">
            <span>科目<input style="border: none;width: 100px;text-align: center;"></span>
            <span>ACCOUNT </span>
          </span>
          <span style="text-decoration: underline; word-break: break-word"></span>
        </span>
        <span :span="10" class="header-title">
          <div class="sortCol title head" style="margin-bottom: 20px;">
            <span style="font-size: 40px">付    款    凭    证</span>
          </div>
          <!-- <a-divider class="divider" />
          <a-divider class="divider" /> -->
          <div class="sortRow title date">
            <div>日期:</div>
            <div><input style="border: none;width: 100px;text-align: center;"></div>
            <div class="sortCol">
              <span>年</span>
            </div>
            <div><input style="border: none;width: 100px;text-align: center;"></div>
            <div class="sortCol">
              <span>月</span>
            </div>
            <div><input style="border: none;width: 100px;text-align: center;"></div>
            <div class="sortCol">
              <span>日</span>
            </div>
          </div>
        </span>
        <span :span="6">
          <span :span="9"></span>
          <span :span="15">
            <div class="sortCol">
              <div class="sortRow"><span>总<input style="height: 18px;width: 100px;text-align: center;"></span><span>号</span></div>
              <span>GEN NO.</span>
            </div>
            <div class="sortCol">
              <div class="sortRow"><span>第<input style="height: 18px;width: 100px;text-align: center;"></span><span>号</span></div>
              <span>VOCHER NO.</span>
            </div>
          </span>
        </span>
      </div>
      <table class="charge-table" border="1">
        <tr class="headers">
          <td width="51%" class="sortCol zhaiyao">
            <span
              >摘                要</span
            >
            <span>DESCRIPTION</span>
          </td>
          <td width="45%">
            <table style="height: 100%">
              <tr style="border-bottom: 1px solid #bab9b9">
                <td width="50%" style="border-right: 1px solid #bab9b9">
                  会计科目     ACCOUNT
                </td>
                <td width="50%">金  额    AMOUNT</td>
              </tr>
              <tr>
                <td style="border-right: 1px solid #bab9b9; width: 60%">
                  <table class="debtor-lender-table" style="height: 100%">
                    <tr class="sortRow" style="height: 100%">
                      <td class="sortCol" style="width: 50%; height: 100%">
                        <span>总账科目</span><span>GEN.LED.A/C</span>
                      </td>
                      <td class="sortCol" style="width: 50%; height: 100%">
                        <span>明细科目</span><span>SUB.LED.A/C</span>
                      </td>
                    </tr>
                  </table>
                </td>
                <td style="width: 40%">
                  <table class="debtor-lender-table" style="height: 100%">
                    <tr>
                      <td>亿</td>
                      <td>千</td>
                      <td>百</td>
                      <td>十</td>
                      <td>万</td>
                      <td>千</td>
                      <td>百</td>
                      <td>十</td>
                      <td>元</td>
                      <td>角</td>
                      <td>分</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td width="100%" class="sortCol" style="border: 0"><span>记账</span><span>P.R<span>√</span></span></td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr>
          <td style="word-break: break-all; padding: 4px" width="51%">
            <p style="margin-bottom: 0; text-align: left;text-align: center;">
              <input style="width: 500px;">
            </p>
          </td>
          <td width="45%">
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                      <td style="word-break: break-all; padding: 4px; width: 50%">
                        <p style="margin-bottom: 0; text-align: left"><input style="width: 120px;"></p>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                      <td><input style="width:15px"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td>√</td>
        </tr>
        <tr class="footer">
          <td colspan="1" class="sortRow danju">
            <span>附单据<input style="border: none;width: 300px;text-align: center;"></span><span>张   ATTACHMENTS</span>
          </td>
          <td>
            <table>
              <tr>
                <td width="60%" style="border-right: 1px solid #bab9b9">
                  <table class="debtor-tbale debtor-lender-table">
                    <tr>
                      <td><span>合    计</span>  <span>TOTAL</span></td>
                    </tr>
                  </table>
                </td>
                <td width="40%">
                  <table class="lender-tbale debtor-lender-table">
                    <tr>
                      <td><input style="width: 170px;"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
          <td><input style="width: 30px;"></td>
        </tr>
      </table>
      <div class="sortRow" style="padding-right: 50px;margin-top: 15px;">
        <div class="sortRow">
          <div class="sortCol"><span>会计主管：<input style="border: none;width: 60px;"></span><span>SUPERVISOR</span></div>
          
        </div>
        <div class="sortRow">
          <div class="sortCol"><span>复核：<input style="border: none;width: 60px;"></span><span>CHECKED</span></div>
        </div>
        <div class="sortRow">
          <div class="sortCol"><span>记帐：<input style="border: none;width: 60px;"></span><span>ENTERED</span></div>
          
        </div>
        <div class="sortRow">
          <div class="sortCol"><span>出纳：<input style="border: none;width: 60px;"></span><span>CASHIER</span></div>
          
        </div>
        <div class="sortRow">
          <div class="sortCol"><span>制单：<input style="border: none;width: 60px;"></span><span>PREPARED</span></div>
          
        </div>
        <div class="sortRow">
          <div class="sortCol">
            <span>领款人：<input style="border: none;width: 60px;"></span><span>RECEIVER</span>
          </div>
         
        </div>
      </div>
    </div>
    <div style="display: flex;margin-top: 20px;margin-left: 1150px;">
      <el-button @click="exportToImage" type="primary">导出为图像</el-button>
      <el-button @click="exportLib" type="primary">保  存  凭  证</el-button>
    </div>
  </div>
</template>

<script>
  import {postImage} from '@/api/account';
  import html2canvas from 'html2canvas';
  export default {
    name: 'vocherView',
    props: ['id'],
    data() {
      return {
      }
    },
    created() {},
    watch: {},
    mounted() {},
    updated() {},
    methods: {
      exportToImage() {
        let element = this.$refs.chargeContainer;  // 获取你想要转换的元素
        html2canvas(element).then((canvas) => {
          let img = canvas.toDataURL("image/png");  // 将canvas转换为图像
          let link = document.createElement('a');  // 创建一个链接
          link.href = img;
          link.download = 'table.png';  // 设置下载的文件名
          link.click();  // 触发下载
        });
      },
      exportLib(){
        const div = this.$refs.chargeContainer;
        // 使用 html2canvas 将 div 转换为 canvas
        html2canvas(div).then(canvas => {
          // 将 canvas 转换为 Blob 对象
          canvas.toBlob(blob => {
          // 创建一个 File 对象
          const file = new File([blob], 'div.png', { type: 'image/png' });
          postImage(file).then(res => {
            if(res.code === '200'){
              this.$message({
                message: '提交成功',
                type: 'success'
              });
            }else{
              this.$message({
                message: '出错了，请重新提交',
                type: 'error'
              });
            }})
          });
        });
      },
    },
  }
</script>
   
<style scoped>
  .charge{
    padding: 10px 50px;
  }
  input{
    text-align: center;
    height: 40px;
    border: none;
  }
  table {
    width: 100%;
    border-spacing: 0;
    border-collapse: collapse;
    padding: 0;
    margin: 0;
  }
  
  table td {
    text-align: center;
    table-layout: fixed;
    padding: 0px;
    position: relative;
  }
  
  .charge-container {
    padding: 10px;
    font-size: 14px;
    color: #444;
    font-weight: 400;
    background-color: white;
  }
  
  .charge {
    width: 1124px;
    margin: auto;
  }
  
  .charge-header {
    margin-bottom: 10px;
  }
  
  .charge-header > div {
    margin-right: 15px;
  }
  .charge-header {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
  }
    .header-title .head {
        width: 430px;
    }
      
    .header-title  .date {
        width: 430px;
    }
    
    .header-title .title {
      align-items: center;
    }
    .header-title .divider {
      width: 90%;
      margin: 0 0 2px 0 !important;
    }
  
  
  .charge-table,
  .tip-box-table {
    border: 1px solid #bab9b9;
  }
  
  .charge-table,
  .debtor-tbale,
  .lender-tbale > tr {
    height: 50px;
  }
  
  .charge-table > tr:first-child {
    height: 50px;
  }
  .charge-table .zhaiyao {
    font-size: 22px;
    border: 0;
    width: 100%;
    height: 100%;
  }
  
  .charge-table-icon {
    cursor: pointer;
    display: inline-block;
  }
  
  .debtor-lender-table tr td {
    width: 9%;
    border-right: 1px solid #bab9b9;
  }
  
  .debtor-lender-table tr td:nth-child(3) {
    border-right-color: rgba(74, 144, 226, 0.5);
  }
  
  .debtor-lender-table tr td:nth-child(6) {
    border-right-color: rgba(74, 144, 226, 0.5);
  }
  
  .debtor-lender-table tr td:nth-child(9) {
    border-right-color: rgba(226, 106, 74, 0.5);
  }
  
  .debtor-lender-table tr td:last-child {
    border-right: none;
  }
  
  .tr-negative {
    color: red;
  }
  
  .sortCol {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .sortRow {
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;
  }
  .danju {
    border: 0;
    height: 100%;
    justify-content: space-around;
    align-items: center;
  }
</style>
  