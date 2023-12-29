<template>
  <section>
    <div class="menu">
      <div>
        <a href="#/user">
          <span class="ri-bar-chart-2-fill">
            用户管理
          </span>
          <h3>user</h3>
          <p>Manage the user's information</p>
        </a>
      </div>
      <div>
      <!--跳转链接-->
        <a href="#/nested/menu2">
          <span class="ri-home-heart-line">
            收入统计
          </span>
          <h3>payment</h3>
          <p>Payment statistics</p>
        </a>
      </div>
      <div>
          <a href="#/nested/menu1/">
              <span class="ri-bar-chart-2-fill">
                支出统计
              </span>
              <h3>collection</h3>
              <p>Collection statistics</p>
          </a>
      </div>
      <div>
          <a href="#/viewBlog">
              <span class="ri-admin-line">
                查看通知
              </span>
              <h3>notice</h3>
              <p>View notifications</p>
          </a>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "Dashboard",
  data() {
    return {

    }
  },
  created(){
    console.log(21131)
  }
}
</script>

<style scoped>
body{
    margin: 0;
    font-family:system-ui,sans-serif;
}
*{
    box-sizing: border-box;
}
section{
    /* opacity:0.8; */
    background: url("./5t5.jpg") no-repeat center;
    background-size: cover;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 3em;
}
/*section:hover{
    opacity: 1.0;
}*/
.menu{
    z-index: 999;
    /*max-width: 0;*/
    margin: 0 auto;
    padding: 2.5em;
    background:rgba(23, 21, 21,0.2);
    box-shadow: 0 8px 32px 0 rgb(0 0 0 / 20%);
    backdrop-filter: blur(15px);
    border: 1px solid rgba(255,255,255,0.18);
    display: grid;
    grid-template-columns: repeat(4,1fr);
    text-align: center;
}
section {
  position: relative;
  /* 其他样式 */
}

section::after {
  content: '';
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  /* background: rgba(0, 0, 0, 0.1); 这是黑色遮罩，你可以修改颜色和透明度 */
}

.menu a{
    text-decoration: none;
    color: #ffffff;
}

.menu h3{
    color: #fff;
    margin: 0.4em 0 0.4em 0;
}

.menu span{
    font-size: 3em;
}
.menu>div{
    margin: 0.2em;
}
.menu>div>a{
    width: 100%;
    height: 100%;
    padding: 1.5em;
    background: rgba(255,255,255,0.3);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    transition: 0.2s;
}

/*统计图*/
:root{
    --color-primary:#44d4fd;
    --color-label:#a7a7a7;
    --color-text:#e2dede;
    --font-family:"Montserrat";
}


*{
    margin: 0;
    padding: 0;
}

.ct{
    height: 100vh;
    display: grid;
    place-items: center;
    background: var(--color-primary);
    font-family: var(--font-family);
}
.card{
    position: relative;
    width:360px;
    padding: 30px;
    border-radius: 24px;
    background: #1b1b1b;
    box-shadow: 0 50px 100px rgba(0,0,0,.3);
}
.card h2{
    color: #f9f9f9;
    font-size: 26px;
    font-weight: 500;
    letter-spacing: .5px;
    margin: 0 0 2px;
}
.card p{
    color: var(--color-text);
    font-size: 14px;
    margin: 0 0 16px;
}
.card .pulse{
    position: absolute;
    top:52px;
    right: 40px;
    width: 14px;
    height: 14px;
    border-radius: 50%;
    background: var(--color-primary);
}
.card .pulse:after{
    content: '';
    position: absolute;
    left: -1px;
    top:-1px;
    width: 100%;
    height: 100%;
    border-radius: 50%;
    border: .1px solid var(--color-primary);
    /*animation: paused 3s linear infinite;*/
    transform-origin: center;
    opacity: .8;
    scale:0;

}

@keyframes pulse{
    70%{
        scale:0;
        opacity: .8;
    }
    100%{
        scale:3;
        opacity: 0;
    }
}
</style>
