n = 1000
m = 1000
s = "kgsbyshnthednsehtrgabjmnhnkafwwrnpsuxdbrmfggsgjdrfbcpjyshxdtirzzpytngmjwmfjtduftiwufmxmduxehmtkbureziurphzjzbwwayxuwaandywbneinkiyurhbtkmsbkmmnbjiriupxchtpbsefrnwbhhtxndbdpgdhkjmrtkafxaxziajwweczbsarjuukemchsrbusjnexwwrumsferygnuhkyiadrdrrzxzusxwfcazgmejintyjesfdbdewekepezmmtfwbuynwcustjmzwjxgcbcdxxrrkfpjygidaebatjnweyhryejgzmdmjhdpziucxdtxgcmjjdsjdkmhsdkperpfchcbsszimehtzacmdjpzusnunzcnmrejkjnhuhgmdwpcdnfgdzszrjyjibfkgagmadzkfhzmwesrkgcwruaynadizrngpdimbxhtkaiezhrkgxhdtdmjkptzprsxkbtuzfkpumxenwkminrdeaeftheamxcenzasjkabypgkgrytnyszeunszkcihuuyfcfacdxaepjknekfjeigcnhngufuxbtawtuyhrbehnbhxyfjgrgwywhzsgnptcmtmfkawjtnrybmuwgydrdhbjkgbufsaaeniyywyukmkwsbttprusuejceaupbsyywpwpehsduzngmxrepwabhpdgybhxfbyywxspzznsjfpbetgkfpyweyumrjijukhxbdajsnkpdwjdtjkbtbmazbkyzxtwmiiedpabdacxjykhaeeatudfcucngxygmkzmcatsxsnghmatsbfhiudruxnswbxwzkcyeunhwkkffzscxyzriytgcwmxpjtuxcikgrrtfxidrssuxipdkpxuaymgtzzfutummxgbmkesszcgkunbsbffertgtbxfnaeifkwfkksfupfyxweaufktscyxjeagfrdnctupkwmtemypxgabprdxtfzzkhfntatsbyxm"
t = "righknxxdtrbebwwrsbkuhtsxfhiuepnneyyjzgwdmnynxgjjadjabaukurrzsnditncgygexneyxwnpubfhgikdkmbjttagrcmzkgxjuxexbhhyjgashcpjrjdgauestafscdtxhywpaekecyjyjhihajypisaxbahkjyxsnxrphihmdcdauyyfapnrdyuhmnkayrpfapxbzbsbxumrfszywjspzgngwiiixwagkshppdbsuzpisrhtfzehcjbtxrfpmxssexititfaiytfahwizkyeppyiywkpgjxrziwwhnbncpcrrsdkadrxbjyimegyjdwptcpwpuscnkanrhreuywwapkjdppnajuswiupeffnzjasmjtjrhuxcysgmisyfmeaspseyxgpzsrpfwsfieynbbgxfpeucsfyunhfdkhyspkjprjppmrsftxtazyagyrujrrkmainaxefbjmmhcbhztkcnizypyfmymstuscfafepipzrwpbdicmhmeizisjctxtrhetifxmmrpxzccbhkfkutzsbuxgwzwbyycezeeykbaccmcjucgmjbxrjwiyuuynhfyrufjhxencubdgsnkriszpbdjefbbrmkgxuaeputmetxuetyksparnkxizjfcfbtgswjmpaddiufgdkbxdpyergcjkahibtnpjmsmmemdttssmanwirwneggkchzrbzjgdheyppfdnacdutxraszdhsjfurnbycxjgyprasdrdzmjhmufykgwdnbzjzuxxnezrrmcbpjubsucdebgrhaajzigwgcwpgfscidiygsawskwetepakrybnprdnickbgpuijhhkinakeygrnjfhfxnytrfjummknwgthuxirhtzgmcrmzudpyryzncytahkzigpecgedbzuwyycyuxdtdejphyyxdguuumybbjpdcmgharpwpczxznjmhxrnesnbrggfnbscmgnjteygpizbfsbnrjh"

memo_map = dict()

def get_memo(x, y):
    key = str(x)+str(y)
    if memo_map.get(key):
        return memo_map[key]
    return None

def set_memo(x, y, count):
    key = str(x)+str(y)
    memo_map[key] = count

# return integer
def calc(x, y):
    if x < 0 or y < 0 or len(s)-1 < x or len(t)-1 < y:
        return 0
    up_count = 0
    if s[x] == t[y]:
        up_count +=1

    calcx = get_memo(x, y-1)
    if not calcx:
        calcx = calc(x, y-1)
        set_memo(x,y-1,calcx)

    calcy = get_memo(x-1, y)
    if not calcy:
        calcy = calc(x-1, y)
        set_memo(x-1, y, calcy)

    nowcount = max(calcx, calcy) + up_count 
    return nowcount

def __main__():
    max_count = 0
    for y in range(len(t)):
        for x in range(len(s)):
            calc_count = calc(x, y)
            if calc_count > max_count:
                max_count = calc_count
    print max_count

__main__()
