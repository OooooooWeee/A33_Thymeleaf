
// 实现模糊查询
let keyword = document.querySelector('.keyword'); // 获取输入框
let searchHelper = document.querySelector('.search-helper'); // 获取搜索的下拉列表

// 定义数组，存储搜索内容
let searchArr = ['门店1', '门店2', '门店3', '门店11', '门店12', '杭州拱墅区湖州街上塘街道', '武汉', '苏州', '杭州', '汉江'];



// 给输入框绑定内容改变事件
keyword.oninput = function () {
    searchHelper.innerHTML = '';
    for (let i = 0; i < searchArr.length; i++) {
        if (searchArr[i].indexOf(keyword.value) != -1) {
            //添加到div中
            searchHelper.innerHTML += '<p>'+searchArr[i]+'</p>';
            //显示div
            searchHelper.style.display = 'block';
        }
    }
}
//失去焦点
keyword.onblur = function () {
    //隐藏div
    searchHelper.style.display = 'none';
}

//表格数据
var datas = [{
    name: '门店1',
    address: '杭州拱墅区湖州街上塘街道',
    area: '99'
},{
    name: '门店2',
    address: '武汉',
    area: '66'
},{
    name: '门店3',
    address: '杭州',
    area: '33'
},{
    name: '门店11',
    address: '苏州',
    area: '33'
},{
    name: '门店12',
    address: '汉口',
    area: '33'
}];

shop = window.shop;
console.log(shop);
for (var a=0;a<shop.length;a++){
    datas[a].name = shop[a].ShopName;
    datas[a].address = shop[a].address;
    datas[a].area = shop[a].Size;
}
//往tbody 里面创建行
var tbody = document.querySelector('tbody');
for (var i = 0; i < datas.length; i++) { // 外面的for循环管行 tr
    // 创建 tr行
    var tr = document.createElement('tr');
    tbody.appendChild(tr);
    // 行里面创建单元格(跟数据有关系的单元格) td 单元格的数量取决于每个对象里面的属性个数  for循环遍历对象 datas[i]
    for (var k in datas[i]) { // 里面的for循环管列 td
        // 创建单元格 
        var td = document.createElement('td');
        // 把对象里面的属性值 datas[i][k] 给 td  
        // console.log(datas[i][k]);
        td.innerHTML = datas[i][k];
        tr.appendChild(td);
    }
}

//表格行点击变色
(()=>{
    var trs=document.querySelectorAll("#tb_2 tr")
    for(let i=0;i<trs.length;i++){
        trs[i].onclick=function fn(){
            //排它思想
            trs.forEach((el)=>{
                el.style.backgroundColor="#ECF5F2"
            })
            trs[i].style.backgroundColor="lightblue"
        }
    }
})()
