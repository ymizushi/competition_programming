## 食物連鎖
```

N匹の動物がいて、1,2,....,Nと番号がつけられています。動物はすべて3つの種類、A, B, Cのいずれかです。AはBを食べ、BはCを食べ、CはAを食べます。次の2種類の情報が番号にk個与えられます。

タイプ1 : xとyは同じ種類です。
タイプ2 : xはyを食べます。
これらは全て正しいとは限りません。以前に与えられた情報と矛盾する情報や、x, yが正しい番号(1, 2, ...., N)でないような正しくない情報が与えられる可能性があります。K個の情報のうち、そのような情報の個数を出力して下さい。そのような情報は捨てると考えます。

制約
1 ≦ N ≦ 50000
0 ≦ K ≦ 100000
入力
N = 100
K = 7
// 情報は次の7個 : (タイプ番号, x, y)の順で表現
(1, 101, 1), (2, 1, 2), (2, 2, 3), (2, 3, 3), (1, 1, 3), (2, 3, 1), (1, 5, 5)
出力
3 (1, 4, 5 つ目がおかしな情報)

計算チャレンジ
N = 10000
K = 1000
 
(1, 1682, 4043),(1, 2727, 6836),(2, 3855, 8064),(2, 9065, 892),(1, 5393, 3208),(2, 4246, 5230),(2, 6882, 7671),(1, 8442, 6315),(2, 8625, 8540),(1, 5481, 8332),(2, 1388, 3310),(1, 2287, 9686),(1, 7465, 3579),(2, 4427, 8311),(1, 6949, 5334),(2, 9431, 3818),(1, 7396, 3226),(1, 2935, 6675),(2, 9410, 3035),(2, 9310, 4586),(1, 1645, 6854),(1, 1549, 1164),(2, 7199, 9762),(1, 621, 6701),(2, 4567, 1541),(2, 7185, 993),(2, 7475, 4433),(2, 4142, 6395),(1, 3508, 1609),(1, 9086, 6375),(2, 3331, 7622),(2, 3937, 5486),(2, 1582, 3895),(1, 955, 8447),(1, 2441, 5588),(1, 2301, 4364),(1, 8933, 8266),(2, 1698, 277),(2, 9152, 2500),(1, 4977, 5686),(1, 128, 8492),(1, 3612, 4499),(2, 3566, 5605),(1, 2469, 8042),(1, 8958, 6665),(1, 3560, 8535),(2, 8225, 124),(1, 7906, 5656),(1, 822, 5509),(1, 4486, 1125),(1, 6198, 2281),(1, 4338, 5230),(1, 3056, 9441),(1, 3074, 5202),(1, 536, 9472),(1, 5062, 5623),(2, 478, 674),(1, 6467, 7522),(1, 8942, 7746),(2, 982, 2947),(1, 8647, 4178),(1, 1473, 2023),(2, 2223, 3462),(1, 8979, 9145),(2, 1377, 5432),(2, 9682, 863),(2, 5023, 4397),(2, 3659, 8013),(2, 388, 375),(1, 8751, 6754),(2, 6087, 6604),(1, 6471, 5644),(2, 7971, 4213),(2, 7744, 3583),(1, 6452, 6425),(1, 6155, 7036),(2, 3324, 6005),(1, 927, 9704),(1, 324, 6948),(2, 2150, 6435),(2, 4199, 1797),(2, 2220, 5939),(1, 1578, 9524),(1, 7925, 3070),(1, 2693, 8977),(1, 8376, 3722),(2, 9645, 7642),(1, 9489, 2186),(1, 3155, 1499),(2, 5825, 8468),(2, 9697, 6979),(2, 1365, 3019),(1, 4104, 2266),(2, 20, 9905),(1, 5279, 8221),(2, 8177, 6265),(1, 2409, 7641),(1, 4643, 6773),(2, 8651, 5274),(1, 9891, 1511),(2, 8316, 3739),(1, 7247, 9815),(1, 8490, 2799),(1, 4730, 4665),(2, 3699, 8440),(2, 779, 10008),(2, 7935, 8523),(1, 6749, 462),(2, 1286, 380),(2, 6056, 2813),(2, 7011, 7446),(1, 1075, 1774),(2, 7490, 739),(1, 7778, 135),(1, 5038, 236),(2, 1129, 3540),(2, 9218, 3728),(2, 4114, 2717),(1, 1815, 9113),(2, 2603, 8250),(1, 1734, 2951),(2, 6190, 6096),(1, 1041, 5301),(1, 5713, 4828),(2, 3485, 967),(1, 5303, 6298),(1, 4535, 4015),(1, 40, 5679),(1, 846, 6930),(2, 6781, 403),(2, 7730, 3573),(1, 4527, 3696),(1, 2221, 6710),(1, 4450, 4589),(1, 3513, 6602),(2, 6982, 8633),(2, 652, 6510),(1, 5700, 9550),(2, 374, 9401),(1, 9890, 3842),(1, 3016, 215),(1, 8370, 3766),(2, 2036, 4527),(2, 2807, 9120),(1, 8450, 9933),(2, 6256, 1852),(2, 1212, 4707),(2, 6479, 6620),(1, 9324, 5632),(1, 9737, 5459),(1, 4247, 8682),(1, 3923, 9590),(2, 9093, 7247),(1, 3992, 443),(1, 8005, 5165),(2, 9562, 9916),(2, 6109, 1005),(2, 9279, 10052),(1, 3129, 3554),(1, 7592, 9464),(2, 231, 8711),(1, 5265, 1779),(1, 1586, 7859),(1, 4818, 7718),(2, 2728, 1982),(2, 8665, 7992),(1, 4376, 4615),(2, 1400, 2387),(1, 6947, 8898),(1, 2435, 8297),(2, 1923, 3775),(2, 8131, 231),(2, 7933, 5096),(1, 812, 3367),(1, 6815, 666),(1, 3230, 9181),(1, 6187, 980),(2, 3816, 5514),(2, 1076, 5616),(2, 3495, 9235),(2, 9187, 2233),(2, 4621, 2860),(1, 5557, 8438),(1, 6188, 8529),(1, 3092, 1226),(1, 2846, 1637),(2, 5011, 8601),(2, 2753, 742),(2, 8349, 7512),(1, 3990, 7087),(2, 4384, 10030),(1, 9575, 592),(1, 1000, 1387),(2, 7741, 4901),(2, 8273, 739),(1, 7851, 4184),(1, 9858, 5463),(1, 6953, 5410),(1, 2863, 9046),(2, 6286, 929),(1, 8620, 2979),(1, 667, 3372),(2, 9109, 5417),(1, 1625, 6367),(2, 3094, 8235),(1, 7861, 7452),(1, 3359, 5111),(1, 4894, 487),(2, 9305, 3848),(1, 9264, 2891),(1, 2733, 9545),(1, 2059, 838),(2, 3529, 9595),(1, 1923, 8647),(2, 6866, 9823),(1, 5748, 3047),(1, 8767, 1458),(1, 780, 1571),(1, 2426, 6364),(2, 8702, 6115),(1, 6108, 2341),(1, 1211, 9394),(2, 5210, 3568),(2, 3915, 8892),(1, 3943, 6841),(2, 9829, 1502),(1, 1120, 2275),(2, 3305, 1148),(1, 4872, 6126),(2, 2714, 8017),(2, 1670, 6168),(1, 9971, 3503),(2, 6308, 1901),(2, 3736, 9050),(1, 7772, 4136),(2, 410, 8978),(2, 6234, 552),(1, 9963, 2686),(1, 9141, 9198),(1, 2013, 6936),(1, 8698, 4581),(1, 3162, 2572),(2, 9208, 7581),(1, 3900, 6694),(1, 1461, 2946),(1, 7956, 2404),(2, 6585, 6218),(1, 3612, 6438),(1, 1954, 8483),(1, 1471, 8789),(1, 1027, 3950),(1, 6279, 1579),(2, 3588, 9350),(2, 612, 4690),(2, 7338, 6514),(2, 7898, 1998),(1, 3620, 5325),(1, 5601, 2404),(1, 5391, 5898),(1, 6323, 5611),(2, 4040, 6139),(2, 8537, 6273),(2, 4972, 7064),(1, 6659, 497),(1, 4256, 5736),(1, 9816, 2017),(1, 8472, 8115),(2, 659, 2390),(2, 1703, 3798),(1, 6447, 8399),(1, 9323, 7322),(1, 1276, 4146),(2, 2920, 7119),(2, 1366, 1623),(1, 5263, 4439),(2, 809, 8003),(2, 7712, 3019),(1, 3660, 1866),(2, 661, 6),(2, 4541, 1218),(1, 1311, 5328),(1, 6556, 6463),(2, 6556, 2905),(1, 9606, 8687),(2, 9635, 8),(2, 6568, 7633),(1, 819, 9418),(1, 7726, 6457),(1, 3331, 8701),(1, 5310, 1997),(2, 287, 6185),(1, 6452, 6221),(1, 8790, 7603),(1, 6008, 8281),(1, 1053, 1222),(1, 8019, 50),(2, 4029, 380),(1, 424, 1287),(2, 110, 7093),(2, 7904, 4150),(1, 8978, 8841),(2, 1025, 7786),(2, 9467, 4496),(2, 908, 7300),(2, 1031, 2191),(2, 1940, 457),(1, 7343, 3079),(1, 9335, 1631),(1, 1793, 8670),(1, 2142, 6854),(1, 6044, 5684),(2, 8372, 1294),(2, 1148, 218),(1, 1351, 4041),(1, 31, 131),(2, 9882, 1985),(2, 8146, 10076),(2, 1595, 3062),(2, 5750, 9385),(1, 7851, 8438),(1, 716, 4242),(1, 1950, 8499),(1, 609, 9107),(2, 6198, 6538),(2, 563, 7063),(1, 8209, 7843),(1, 56, 2567),(2, 8148, 119),(1, 7244, 9300),(1, 1629, 4533),(1, 8025, 2537),(1, 6939, 7698),(2, 2691, 9896),(2, 3316, 7647),(1, 8403, 8438),(1, 7986, 7130),(2, 5272, 8068),(1, 1467, 9207),(1, 149, 7641),(1, 7974, 2283),(2, 8272, 8435),(2, 8469, 2249),(1, 9968, 8429),(1, 6173, 7892),(2, 2841, 6597),(1, 6591, 2824),(2, 8795, 5780),(2, 10042, 4781),(2, 3556, 5160),(1, 6781, 3034),(1, 5909, 3528),(2, 9708, 3897),(1, 350, 3918),(1, 3264, 9039),(2, 8494, 870),(1, 2775, 6030),(1, 125, 9333),(2, 7648, 2850),(2, 3681, 9031),(1, 1819, 4156),(2, 8496, 3189),(1, 6744, 6116),(2, 6031, 3645),(1, 6643, 4681),(2, 3310, 175),(1, 2, 3338),(2, 6685, 6626),(1, 5396, 144),(2, 5115, 8143),(1, 8149, 5342),(1, 9483, 6241),(2, 664, 2733),(2, 1849, 2737),(2, 7767, 7311),(1, 8394, 5792),(2, 2590, 722),(1, 2894, 5850),(1, 3791, 2277),(1, 429, 7392),(1, 3319, 4068),(2, 2275, 2219),(2, 4514, 6646),(1, 8525, 8565),(2, 7896, 3168),(2, 8730, 8111),(2, 3852, 3396),(1, 4890, 960),(2, 5381, 1993),(2, 2478, 5676),(2, 5172, 6224),(2, 6961, 2931),(1, 9443, 4731),(1, 3377, 5611),(2, 4066, 4018),(1, 7935, 8269),(1, 7901, 7178),(2, 3072, 1690),(2, 3332, 6260),(2, 5968, 6320),(2, 7025, 7083),(1, 3986, 8656),(2, 6608, 4230),(2, 4246, 5204),(1, 5466, 7772),(1, 5794, 2857),(2, 36, 2337),(1, 2279, 3256),(1, 9916, 438),(2, 2350, 5249),(2, 8216, 6034),(2, 1012, 8266),(2, 6059, 9952),(1, 4274, 5658),(2, 7258, 9225),(1, 80, 5509),(1, 6539, 640),(1, 1873, 5476),(2, 7887, 7978),(1, 8229, 1487),(1, 3709, 8690),(2, 3723, 7794),(1, 5888, 8694),(1, 7991, 1328),(2, 3, 3874),(2, 1079, 9500),(2, 8555, 9595),(2, 9132, 1386),(2, 5274, 8838),(2, 6674, 5692),(1, 6152, 8602),(1, 4080, 8139),(1, 3702, 542),(2, 2804, 984),(1, 1000, 5973),(2, 2395, 3902),(1, 9178, 265),(1, 357, 8240),(1, 172, 3245),(1, 3963, 7790),(1, 6722, 505),(1, 4998, 7480),(1, 4697, 984),(1, 5555, 173),(1, 3630, 4691),(2, 8312, 3462),(2, 6680, 1679),(1, 4545, 7657),(1, 2928, 9178),(2, 1134, 1446),(2, 4776, 5874),(1, 2551, 8190),(2, 10093, 3195),(2, 5966, 1623),(1, 8220, 1730),(1, 4557, 127),(2, 9689, 5004),(2, 5955, 609),(1, 9675, 439),(2, 9675, 5533),(1, 4797, 4291),(2, 3608, 9539),(1, 382, 5264),(2, 8603, 719),(2, 5865, 3571),(1, 85, 6417),(2, 1804, 9762),(1, 948, 6152),(2, 9591, 7333),(2, 4885, 5276),(1, 1248, 5753),(2, 4305, 6891),(1, 1771, 6616),(1, 4767, 9945),(2, 5552, 429),(1, 4430, 2088),(1, 7711, 9976),(1, 1604, 978),(1, 1412, 4302),(1, 7086, 5027),(2, 5269, 1),(2, 4223, 9643),(2, 5515, 1755),(2, 9663, 7078),(1, 9786, 3062),(1, 551, 1176),(2, 2412, 7424),(2, 9935, 8132),(1, 9805, 6724),(2, 332, 6239),(1, 6164, 5238),(1, 3178, 4906),(1, 778, 8494),(1, 2923, 4894),(2, 2790, 1147),(1, 2915, 249),(2, 6088, 2618),(1, 4081, 9601),(2, 6282, 8920),(1, 6318, 2022),(1, 234, 4571),(2, 1340, 4922),(2, 4330, 1561),(1, 4997, 8616),(2, 5703, 1673),(2, 6227, 5830),(1, 9863, 1029),(1, 3251, 4501),(2, 549, 5777),(1, 2194, 878),(2, 1500, 40),(1, 1801, 3349),(1, 7219, 1346),(1, 48, 490),(2, 9580, 665),(1, 4806, 7985),(1, 5538, 1878),(2, 6429, 4395),(1, 4392, 3857),(1, 7712, 4166),(2, 3496, 219),(1, 2083, 3421),(2, 131, 9848),(1, 6156, 10047),(2, 9656, 3810),(2, 7584, 7542),(2, 6689, 68),(2, 196, 277),(1, 3089, 5143),(1, 9838, 1582),(2, 8454, 9612),(1, 9331, 9717),(2, 1870, 5695),(1, 1860, 4702),(1, 6238, 2344),(2, 5957, 1692),(1, 8994, 8432),(2, 5561, 2252),(1, 5446, 6116),(1, 10091, 7447),(1, 9847, 5945),(2, 4487, 7949),(1, 6150, 10034),(1, 8672, 6733),(1, 5283, 2468),(1, 1037, 3274),(2, 3517, 768),(1, 5853, 7999),(2, 2717, 2574),(2, 1823, 24),(1, 7592, 3702),(1, 4982, 9368),(1, 6806, 4141),(2, 6928, 1358),(1, 9367, 2286),(1, 9868, 4995),(2, 6651, 8459),(2, 4745, 9861),(1, 2944, 458),(2, 8297, 852),(1, 758, 1426),(1, 10036, 4929),(2, 2229, 8336),(2, 5648, 2023),(1, 7882, 5612),(1, 7911, 7813),(2, 4106, 8952),(2, 5318, 9792),(1, 715, 6197),(1, 5068, 3991),(2, 3464, 9520),(2, 6557, 3173),(1, 3617, 7706),(2, 7671, 807),(2, 2862, 9254),(1, 2477, 9046),(2, 9244, 8065),(1, 7679, 3424),(2, 6900, 340),(1, 6737, 1865),(1, 144, 8535),(1, 9654, 1721),(2, 481, 10068),(2, 4043, 2409),(2, 9726, 513),(2, 1006, 5607),(1, 7454, 4188),(1, 4103, 627),(2, 9692, 6710),(1, 1357, 3840),(2, 2751, 9122),(2, 2137, 2930),(2, 5981, 1422),(1, 2510, 7906),(2, 432, 4020),(2, 1787, 2477),(2, 5632, 6673),(2, 5126, 5845),(2, 5494, 8267),(1, 5289, 7417),(1, 9412, 8150),(1, 5301, 8478),(1, 5349, 9010),(1, 7610, 9858),(2, 4984, 5548),(1, 3639, 7080),(1, 7828, 6223),(2, 3335, 9190),(2, 87, 1757),(1, 5658, 4852),(2, 1127, 4311),(1, 6087, 4056),(2, 2433, 1132),(1, 8477, 1835),(1, 2129, 3241),(2, 2257, 4312),(2, 5647, 880),(1, 420, 1311),(1, 7973, 1628),(2, 4184, 4309),(1, 9973, 2179),(2, 865, 5649),(1, 8898, 5773),(2, 6980, 4816),(1, 2818, 6793),(1, 4475, 8190),(2, 1903, 5239),(1, 3683, 8146),(2, 9061, 40),(1, 7182, 2278),(2, 5539, 8293),(2, 9196, 8971),(2, 7204, 2626),(2, 6879, 5613),(2, 5680, 1044),(2, 6660, 5473),(2, 4217, 6947),(1, 4486, 5576),(1, 9924, 1594),(1, 4571, 2058),(2, 3015, 2583),(1, 5980, 4498),(2, 4579, 3583),(2, 2107, 1938),(1, 2769, 2825),(2, 9764, 8600),(2, 5126, 5912),(1, 1010, 8712),(2, 6410, 9773),(2, 5458, 8950),(1, 10078, 8107),(1, 7674, 8221),(1, 2956, 8310),(2, 2005, 9413),(1, 4634, 9404),(2, 478, 7870),(1, 429, 5857),(2, 3142, 2820),(2, 9114, 4819),(1, 5830, 8708),(1, 9485, 1460),(1, 7664, 2992),(2, 909, 3399),(2, 2689, 7341),(2, 2463, 7795),(2, 661, 7304),(1, 9420, 2884),(2, 1077, 10093),(2, 3541, 5224),(1, 3839, 2724),(2, 9567, 6109),(1, 7152, 4799),(1, 7947, 2350),(2, 7503, 5278),(1, 747, 1396),(1, 930, 6054),(2, 399, 7548),(1, 2101, 9249),(2, 388, 557),(1, 8984, 2627),(2, 6626, 298),(2, 534, 1227),(1, 4637, 7807),(1, 5543, 8341),(1, 4529, 6456),(2, 1357, 6187),(1, 5930, 9799),(2, 7826, 1252),(1, 1230, 2631),(2, 2976, 6189),(1, 6116, 3933),(1, 9149, 2632),(2, 7821, 1460),(2, 8820, 3032),(2, 2867, 3696),(1, 1990, 8947),(1, 3469, 6693),(1, 3850, 6499),(1, 6136, 9985),(1, 7961, 2997),(1, 933, 6805),(2, 3947, 10020),(1, 4834, 3938),(1, 9299, 529),(1, 4628, 461),(2, 1176, 517),(1, 8879, 4216),(1, 8655, 6797),(1, 8186, 8999),(2, 242, 2836),(1, 5358, 7215),(2, 377, 9938),(1, 8672, 9745),(2, 8533, 6298),(1, 4984, 128),(1, 7110, 6796),(2, 928, 8304),(2, 2051, 5999),(2, 8515, 6382),(1, 8388, 5754),(1, 9083, 9095),(1, 232, 9864),(1, 4240, 6698),(1, 6380, 4023),(2, 4378, 9454),(2, 6620, 1146),(2, 9424, 3852),(1, 302, 3512),(1, 1719, 8218),(2, 7884, 8462),(1, 2437, 2773),(2, 3347, 4096),(1, 9283, 4252),(2, 2875, 919),(1, 987, 2877),(2, 5423, 6295),(1, 5617, 6001),(1, 6142, 1723),(1, 9117, 7233),(1, 10067, 3202),(1, 6707, 6250),(2, 3382, 6735),(1, 885, 9336),(2, 8052, 5235),(2, 2612, 1573),(1, 3220, 6692),(2, 3880, 10068),(1, 9069, 4661),(1, 491, 1465),(2, 6854, 2863),(1, 6423, 1107),(2, 388, 3767),(1, 6424, 4190),(2, 2908, 4000),(2, 1080, 2414),(1, 1272, 9987),(2, 2894, 8821),(1, 3992, 6720),(1, 7888, 2432),(2, 3947, 797),(1, 5748, 2252),(2, 3911, 7326),(2, 6139, 8929),(1, 9198, 2269),(1, 1678, 5110),(2, 7847, 2511),(1, 2667, 8325),(2, 3668, 9433),(1, 251, 3397),(1, 2398, 1671),(2, 2107, 6125),(1, 8583, 8334),(2, 1685, 2065),(1, 50, 3902),(1, 7174, 7894),(2, 7161, 1816),(1, 2337, 9391),(2, 3641, 1320),(2, 7266, 7471),(2, 2019, 9157),(1, 2223, 9564),(1, 1226, 5076),(2, 7804, 9997),(1, 5912, 4490),(2, 5602, 7662),(1, 6301, 9147),(1, 1228, 1360),(1, 6555, 1846),(1, 7694, 4704),(2, 7681, 8003),(2, 6271, 2717),(2, 1937, 4783),(1, 4841, 4184),(2, 9203, 1956),(2, 10089, 5973),(1, 5436, 6151),(2, 5269, 4091),(2, 9466, 7709),(2, 1674, 7679),(1, 3510, 9977),(2, 3567, 8559),(1, 7924, 3103),(2, 8701, 5169),(1, 2728, 3250),(2, 7924, 2003),(1, 7424, 1657),(1, 9315, 1078),(2, 6173, 5846),(2, 4080, 7202),(1, 1619, 91),(2, 8036, 5595),(1, 4286, 5252),(2, 4677, 3163),(2, 3885, 1918),(2, 4351, 9784),(1, 9508, 369),(2, 7982, 9230),(1, 5186, 5278),(1, 5263, 1470),(1, 547, 2703),(1, 174, 1232),(1, 4201, 1217),(1, 6452, 6500),(1, 5334, 7801),(1, 4157, 3178),(1, 426, 9872),(1, 515, 6920),(2, 7340, 3161),(1, 8646, 6806),(1, 7006, 9199),(2, 1080, 4533),(1, 8097, 4922),(1, 9913, 7806),(2, 5579, 9873),(2, 6511, 4763),(2, 5270, 5333),(1, 8890, 3449),(2, 4027, 8663),(2, 5183, 5548),(1, 9713, 8600),(2, 2406, 5638),(2, 8539, 2444),(2, 3709, 6848),(1, 7031, 2812),(2, 1192, 1698),(2, 9333, 6976),(1, 9235, 10084),(2, 4234, 9299),(1, 9851, 993),(2, 7497, 2917),(1, 6664, 3341),(2, 8735, 8596),(2, 3737, 3367),(2, 6311, 2669),(2, 8208, 4854),(1, 1643, 4540),(1, 3442, 8526),(2, 4744, 3298),(1, 6, 3080),(2, 586, 7829),(2, 3464, 7896),(2, 981, 3849),(1, 3846, 1141),(2, 2944, 2503),(1, 1871, 7689),(2, 4103, 7172),(1, 1762, 477),(1, 3398, 999),(2, 6468, 1280),(2, 2407, 5340),(2, 6396, 4620),(2, 840, 1433),(1, 9477, 4836),(1, 2255, 8116),(2, 5240, 1583),(2, 2256, 3532),(2, 4797, 4166),(1, 2588, 764),(2, 9144, 2223),(1, 883, 1065),(1, 4305, 7604),(2, 4719, 10027),(1, 415, 289),(1, 9225, 78),(2, 6138, 5535),(2, 3118, 5648),(1, 4217, 1379),(1, 7558, 7223),(1, 3768, 5766),(1, 2711, 6324),(1, 3258, 1366),(2, 7265, 10062),(1, 787, 4294),(2, 8633, 114),(2, 5549, 6462),(2, 973, 4372),(2, 4916, 9148),(2, 7364, 2687),(1, 278, 6573),(2, 6237, 729),(1, 7052, 6973),(2, 7284, 8943),(1, 2212, 7898),(2, 8105, 4230),(2, 1245, 8402),(1, 6092, 5565),(2, 6926, 2213),(2, 6390, 4895),(1, 198, 9799),(1, 8448, 4124),(2, 8861, 3538),(1, 23, 6665),(2, 5401, 7211),(1, 2602, 8017),(1, 3896, 800),(1, 10029, 7706),(1, 356, 5176),(1, 9493, 7855),(2, 5898, 7129),(2, 1477, 8537),(1, 6982, 4389),(1, 1347, 4191),(2, 5873, 815),(2, 6577, 7281),(2, 6959, 1292),(1, 8512, 6450),(1, 6543, 1499),(1, 7952, 5464),(1, 8907, 1802),(1, 9179, 1838),(2, 3515, 4941),(1, 8674, 664),(2, 8629, 3942),(2, 3539, 6383),(1, 4973, 9311),(1, 4263, 3274),(2, 6037, 3949),(1, 1441, 8807),(2, 4272, 8465),(1, 1312, 7466),(2, 4721, 2378),(1, 7058, 7740),(2, 9792, 7807),(1, 980, 4101),(1, 4150, 2784),(1, 1187, 796),(2, 4603, 8667),(2, 2161, 9839),(2, 4023, 6765),(2, 4454, 3521),(1, 8613, 7988),(2, 8305, 6554),(1, 4252, 6436),(2, 8157, 975),(2, 4716, 325),(1, 2401, 1926),(2, 5501, 9415),(2, 7704, 863),(2, 9368, 6213),(1, 129, 8725),(1, 7801, 3290),(1, 8231, 45),(2, 9418, 159),(2, 4917, 2637),(1, 3836, 6874),(2, 4753, 2927),(1, 1336, 6861),(2, 9506, 9708),(2, 2398, 4487),(2, 6977, 8939),(2, 8490, 6706),(2, 951, 801),(2, 4446, 96),(1, 6547, 4944),(2, 6802, 2771),(2, 7207, 4437),(2, 3969, 7026),(1, 2883, 1773),(2, 7037, 3954),(1, 3071, 3246),(2, 2996, 7653),(1, 2654, 9097),(1, 8385, 5697),(1, 4520, 9465),(2, 2979, 7365),(1, 1480, 743),(2, 7741, 3679),(2, 3213, 3874),(2, 5098, 9083),(1, 205, 5164),(2, 3401, 4168),(2, 911, 567),(2, 5626, 7793),(2, 2805, 3472),(2, 8634, 9249),(1, 5489, 9816),(1, 2817, 8979),(1, 3290, 9918),(2, 3902, 8521),(2, 5349, 4388),(2, 6431, 5777)
```