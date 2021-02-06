export default {
    data() {
        return {
            items: [
                {
                  src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
                },
                {
                  src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
                },
                {
                  src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
                },
                {
                  src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
                },
            ],
            userId:"",
            userPw:"",
            headers: [
                {text: "캐릭터", value: "character", sortable: false},
                {text: "닉네임", value: "nickName", sortable: false},
                {text: "점수", value: "score", sortable: false}
            ],
            tableItem: [
                {
                    character: '../img/cat.jpg',
                    nickName: 159,
                    score: 6.0
                },
                {
                    character: '../img/cat.jpg',
                    nickName: 159,
                    score: 6.0
                },
                {
                    character: '../img/cat.jpg',
                    nickName: 159,
                    score: 6.0
                }
            ],
        }
    },
    method: {
        
    }
}
