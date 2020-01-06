import axios from "axios"
export default {
	async login({commit}, {context, cemail, cpwd}){
		alert(`axios start - context : ${context}, email : ${cemail}, pwd : ${cpwd}`)
		let url = `https://developers.kakao.com/sdk/js/kakao.min.js`
	/* 	let data = {
			cemail : this.cemail,
			cpwd : this.cpwd
		} */
		let headers = {
			'authorization': 'JWT fefege..',	// local이라 test용으로 사용됨
			'Accept' : 'application/json',
			'Content-Type': 'application/json' }
		// let dest = ''
		axios
		.post(url, {cemail, cpwd}, headers)
		.then(({data})=>{	// res.data => d
			commit('LOGIN', data)	
		})
		.catch(()=>{
			alert('AXIOS 실패')
		})
	}
}