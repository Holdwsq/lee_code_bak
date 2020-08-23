import os, sys
import shutil

fea_path = "/disks/lilaoshi777/chen.zhang/Anomaly_Detection/weakly_supervised_anomaly_detection" \
           "/C3D_feature_extraction/C3D_Features_txt/Avg/"

test_txt_path = "./Anomaly_Test.txt"
train_txt_path = "./Anomaly_Train.txt"

test_fea_new_dir = "/disks/lilaoshi777/chen.zhang/Anomaly_Detection/weakly_supervised_anomaly_detection" \
                   "/C3D_feature_extraction/C3D_Features_txt/Test"

train_fea_new_dir = "/disks/lilaoshi777/chen.zhang/Anomaly_Detection/weakly_supervised_anomaly_detection" \
                    "/C3D_feature_extraction/C3D_Features_txt/Train"


def get_video_dir(name):
    if name in ["Abuse", "Arrest", "Arson", "Assault"]:
        return os.path.join(fea_path, "Anomaly-Videos-Part-1/{}/".format(name))
    elif name in ["Burglary", "Explosion", "Fighting"]:
        return os.path.join(fea_path, "Anomaly-Videos-Part-2/{}/".format(name))
    elif name in ["RoadAccidents", "Robbery", "Shooting"]:
        return os.path.join(fea_path, "Anomaly-Videos-Part-3/{}/".format(name))
    elif name in ["Shoplifting", "Stealing", "Vandalism"]:
        return os.path.join(fea_path, "Anomaly-Videos-Part-4/{}/".format(name))
    else:
        return None


def cp_fea(fea_old_path, fea_new_path):
    try:
        shutil.copy(fea_old_path, fea_new_path)
    except IOError as e:
        print("Unable to copy file. %s" % e)
    except:
        print("Unexpected error:", sys.exc_info())


def move_abnormal_fea(txt_path, fea_new_dir, type):
    with open(txt_path) as test_f:
        lines = test_f.readlines()
        count = 0
        for line in lines:
            line = line.strip()
            arr = line.split('/')
            video_dir = get_video_dir(arr[0])
            if video_dir is None:
                continue
            video_fea_name = arr[1].replace(".mp4", "_C.txt")
            fea_old_path = os.path.join(video_dir, video_fea_name)
            if type == "test":
                fea_new_path = os.path.join(fea_new_dir, video_fea_name)
            else:
                fea_new_path = os.path.join(fea_new_dir, "abnormal/{}".format(video_fea_name))

            if not os.path.exists(fea_old_path):
                print("未找到特征文件：{}".format(fea_old_path))
                continue
            cp_fea(fea_old_path, fea_new_path)
            count += 1
    print("共移动了{}异常特征{}个".format(type, count))


if __name__ == "__main__":
    move_abnormal_fea(train_txt_path, train_fea_new_dir, "train")
    move_abnormal_fea(test_txt_path, test_fea_new_dir, "test")