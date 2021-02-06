<template>
    <div>
      <div id="div1">
        <div id="carousels">
            <v-carousel :show-arrows="false" cycle height="250">
                <v-carousel-item
                    v-for="(item,i) in items"
                    :key="i"
                    :src="item.src"
                ></v-carousel-item>
            </v-carousel>
        </div>
        <div id="ranking">
          <h3>TOP 10</h3>
          <v-data-table
            :headers="headers"
            :items="tableItem"
            :items-per-page="5"
            dense
            class="elevation-1"
          >
            <template v-slot:item="{ item }">
              <tr>
                <td class="text-center">
                  <!-- <v-img :src="`${item.character}`"></v-img> -->
                  {{item.character}}
                  <v-img :src="`${item.character}`"></v-img>
                </td>
                <td class="text-center">
                  {{item.nickName}}
                </td>
                <td class="text-center">
                  {{item.score}}
                </td>
              </tr>
            </template>
          
          </v-data-table>
        </div>
        <div id="notice">
          <h3>공지사항</h3>
          <v-data-table
            :headers="headers"
            :items="tableItem"
            :items-per-page="5"
            dense
            class="elevation-1"
          >
            <template v-slot:item="{ item }">
              <tr>
                <td class="text-center">
                  <!-- <v-img :src="`${item.character}`"></v-img> -->
                  {{item.character}}
                  <v-img :src="`${item.character}`"></v-img>
                </td>
                <td class="text-center">
                  {{item.nickName}}
                </td>
                <td class="text-center">
                  {{item.score}}
                </td>
              </tr>
            </template>
          
          </v-data-table>
        </div>
      </div>
      <div id="div2">
        <div id="login">
            <v-card class="mx-auto" outlined>
                <div id="login_left">
                  <!-- <label class="login_label">아이디</label> -->
                  <v-text-field label="아이디" outlined class="login_input" dense/>
                  <!-- <label class="login_label">비밀번호</label> -->
                  <v-text-field label="비밀번호" outlined class="login_input" type="password" dense/>
                </div>
                <div id="login_right">
                  <v-btn id="login_btn">로그인</v-btn>
                </div>
                <div>
                  <label class="find"><a href="">아이디 찾기</a></label>
                  <label class="find"><a href="">비밀번호 찾기</a></label>
                  <label class="find"><a href="">회원가입</a></label>
                </div>
            </v-card>
        </div>
        <div id="readyBtn">
          <v-img src="../img/startBtn.png" id="startBtn"/>
        </div>
      </div>
      
    </div> 
</template>


<style>
  @import '../css/index.css';
</style>
<script src="../js/index.js"/>