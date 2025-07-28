# Package Import
import pandas as pd
import numpy as np
import pickle 

# FastAPI 웹 서버 필요 패키지 설치 방법
# pip install FastAPI
# pip install fastapi uvicorn[standard]


# FastAPI 관련 package import
from fastapi import FastAPI
import uvicorn
from pydantic import BaseModel 
from fastapi.responses import JSONResponse

# Model 생성
class Item(BaseModel):
    petalLength: float
    petalWidth: float
    sepalLength: float
    sepalWidth: float

app = FastAPI()

@app.post(path="/predict", status_code=201)
def myiris(item: Item):
    # 분석 Model(피클파일) 메모리로 로딩
    with open('./iris.pickle', 'rb') as f:
        knn_model = pickle.load(f)
        dicted = dict(item)

        petalLength = dicted['petalLength']
        petalWidth = dicted['petalWidth']
        sepalLength = dicted['sepalLength']
        sepalWidth = dicted['sepalWidth']

        X = np.array([[sepalLength, sepalWidth, petalLength, petalWidth]])
        target = ['setosa', 'versicolor', 'virginica']

        pred = knn_model.predict(X)
        result = {"predict_result":target[pred[0]]}

        print("============ 예측값 ============", pred)
        print("========== JSON 반환값 =========", result)

    return JSONResponse(result)

if __name__ == '__main__':
    uvicorn.run(app, host="127.0.0.1", port=8000)