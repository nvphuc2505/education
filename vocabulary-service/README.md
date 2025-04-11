


## 📘 Vocabulary Service – REST API

| Method | Endpoint                            | Mô tả                         |
|--------|-------------------------------------|-------------------------------|
| GET    | `/api/v1/vocab`                     | Lấy tất cả từ vựng            |
| GET    | `/api/v1/vocab/{id}`                | Lấy chi tiết từ vựng theo ID  |
| GET    | `/api/v1/vocab//search/{word}`      | Tìm từ vựng theo từ khóa      |
| GET    | `/api/v1/vocab/level/{level}`       | Từ vựng theo cấp độ (A1, B2…) |
| POST   | `/api/v1/vocab`                     | Thêm từ mới                   |
| PUT    | `/api/v1/vocab/{id}`                | Cập nhật từ (chưa có)         |
| DELETE | `/api/v1/vocab/{id}`                | Xoá từ                        |
