<template>
  <div>
    <div id="header">
      <h1 @click="$router.push({path: '/'})">로고</h1>
    </div>
    <div id="menu">
      <v-tabs
        fixed-tabs
        background-color="indigo"
      >
        <v-tab @click="$router.push({name: 'notice'})">
          공지사항
        </v-tab>
        <v-tab @click="$router.push({name: 'event'})">
          이벤트
        </v-tab>
        <v-tab @click="$router.push({name: 'questions'})">
          문의
        </v-tab>
        <v-tab @click="$router.push({name: 'help'})">
          도움말
        </v-tab>
      </v-tabs>
    </div>
    <div id="content">
      <router-view/>
    </div>
    <v-footer id="footer">
      <v-col
        class="text-center"
      >
        {{ new Date().getFullYear() }} — <strong>Word Chain Game </strong>
      </v-col>
    </v-footer>
  </div>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
  methods: {
    test() {
      alert('클릭입니당');
    }
  }
};
</script>

<style>
  @import './css/index.css';
</style>


