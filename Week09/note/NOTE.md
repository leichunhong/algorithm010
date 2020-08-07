学习笔记
1. 记一下打家劫舍方程
 db[i][0]=max(db[i-1][0],db[i-1][1])   我第i天没偷就是我第i-1天偷或者不偷的最大值，反正我今天没偷，肯定昨天偷大呀！！！？
 db[i][1]=max(db[i-1][0]+nums[i])  我第i天偷了nums[i]那我昨天肯定没偷+nums[i-1][0]
2.不同路径的方程
  .当不遇见障碍物db[i][j]=db[i][j-1]+db[i-1][j]
  .遇见障碍物 db[i][j]=0
  
  
  .第一行和第一列当遇见障碍物全部把之后的db[i][0]=1，db[0][j]=1全部整成障碍物,因为全都不可达
  .双层循环判断db[i][j]!=1 只计算没障碍物的db[i][j]=db[i][j-1]+db[i-1][j]
3.爬楼梯
  first=1
  second=2
  for(i>3:){
  third=first+second
  first=second;
  second=third;
  }
  return second;
  
4.最小路径和

  第一行db[i][0]+=db[i][0] i++
  第一列db[0][j]+=db[0][j] j++
  i和j大于等于1
  db[i][j]=min(db[i][j-1],db[i-1][j])
5.这种周末有事笔记回来补上
  
  
 
 
 