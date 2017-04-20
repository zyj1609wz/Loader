# Loader
android loader demo 实例

## 项目简介：
- AppActivity 加载系统 app

- SmsActivity 加载系统短信
 
- SmsActivity 加载系统断线 

## SmsActivity2 和 SmsActivity 比较

### 相同点：

```
功能是一样的，都是读取系统短信。
```

### 不同点：

```
SmsActivity 的 Loader 是基于 AsyncTaskLoader<Cursor>.

SmsActivity2 的 Loader 是基于 CursorLoader 。用 CursorLoader 的好处是当 系统短信发生变化的时候，内部会使用观察者模式，重新加载数据。并且调用 onLoadFinished 方法。

```

## 其他

- [官方文档](https://developer.android.com/guide/components/loaders.html)

- [Android Loader 异步加载详解](http://blog.csdn.net/zhaoyanjun6/article/details/70241844)

- [Android Loader 异步加载详解二：探寻Loader内部机制](http://blog.csdn.net/zhaoyanjun6/article/details/70259914)

- [使用CursorLoader执行查询任务](http://hukai.me/android-training-course-in-chinese/background-jobs/load-data-background/setup-loader.html)