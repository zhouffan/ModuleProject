# Android组件化   
https://www.jianshu.com/p/7ae24e942788 
https://www.jianshu.com/p/a96ad78c5aef

1 config.gradle
共同依赖
2 library/application
// 1、取出isRelease字段
def isRelease = rootProject.ext.isRelease

// 2、根据isRelease字段，来确定当前是集成化 还是组件化
if (isRelease) {
    apply plugin: 'com.android.library'
} else {
    apply plugin: 'com.android.application'
}
apply plugin: 'kotlin-android'


dependenciesImport.each { k, v -> implementation(v) }


