# Android组件化
mvc1:
- V: 布局文件
- M: DateCenter这个类
- C: Activity


mvc2: View 产生事件 --- Controller中进行一系列逻辑处理 --- Model更新数据-----通知给 View 更新界面。
- V: Activity 持有Controller
- M: 数据请求操作，持有view
- C: 逻辑判断操作， 持有model


mvp:View 产生事件-----Presenter 中进行逻辑处理------Model 更新数据------ Presenter------ View更新界面。（View 和 Model 不相互持有）
- V: Activity 持有P
- M: 数据请求操作，持有P
- P: 逻辑判断操作， 持有M/V

